<?php
/*==============================================================================*\
|| ############################################################################ ||
|| # vBulletin 5.0.1                   # ||
|| # ----------------------------------------------------------------         # ||
|| # Copyright ©2000-2013 vBulletin Solutions Inc. All Rights Reserved. # ||
|| # This file may not be redistributed in whole or significant part.         # ||
|| # With great thanks to the contribution provided by Andreas                # ||
|| # for the development of this script.                                      # ||
|| # ---------------- VBULLETIN IS NOT FREE SOFTWARE ----------------         # ||
|| # http://www.vbulletin.com | http://www.vbulletin.com/license.html         # ||
|| ############################################################################ ||
\*==============================================================================*/

// ######################## SET PHP ENVIRONMENT ###########################
// for some reason adding the @ to the beginning of this line makes it not work
error_reporting(E_ALL & ~E_NOTICE);

if (!function_exists('readline'))
{
	function readline( $prompt = '' )
	{
		echo $prompt;
		return rtrim( fgets( STDIN ), "\n" );
	}
}

function fetch_postindex_exec_time($seconds)
{
	static $ph_hours = '', $ph_minutes = '', $ph_seconds = '';
	if (empty($ph_hours) OR empty($ph_minutes) OR empty($seconds))
	{
		$vbphrase = vB_Api::instanceInternal('phrase')->fetch(array('x_seconds', 'x_minutes_and_y_seconds', 'x_hours_y_minutes_and_z_seconds'));
		$ph_hours = $vbphrase['x_hours_y_minutes_and_z_seconds'];
		$ph_minutes = $vbphrase['x_minutes_and_y_seconds'];
		$ph_seconds = $vbphrase['x_seconds'];
	}
	$d['h'] = floor($seconds/3600);
	$d['m'] = floor( ($seconds - ($d['h']*3600)) / 60 );
	$d['s'] = $seconds % 60;
	$time = "$d[s] seconds";
	$phrase = $ph_seconds;
	$params = array($d['s']);
	if (!empty($d['m']))
	{
		$phrase = $ph_minutes;
		array_unshift($params, $d['m']);
	}
	if (!empty($d['h']))
	{
		$phrase = $ph_hours;
		array_unshift($params, $d['h']);
	}
	return vB_Phrase::parsePhrase($phrase, $params);
}

// this file will most likely be run from the forum root
$def_core = realpath('core');
$forumspath = '';
// the following phrases can't be fetched through the phrase API. We need to know the core path first.
do
{
	if (!empty($forumspath))
	{
		print ("\n$forumspath is not a valid directory, please try again\n");
	}
	$forumspath = trim(readline("Please enter the path to your vBulletin directory (default $def_core): "));
	if (empty($forumspath))
	{
		$forumspath = $def_core;
	}
}
while (!is_dir($forumspath));
// ##################### DEFINE IMPORTANT CONSTANTS #######################
define('THIS_SCRIPT', 'searchindex');
define('VB_AREA', 'Maintenance');
define('SKIP_SESSIONCREATE', 1);
define('VB_ENTRY', true);
define('NOCOOKIES', 1);

chdir($forumspath);

// ########################################################################
// ######################### START MAIN SCRIPT ############################
// ########################################################################

require_once('./global.php');
//require_once(DIR . '/includes/adminfunctions.php');
//require_once(DIR . '/includes/functions_filesystemxml.php');
//require_once(DIR . '/includes/class_filesystemxml_template.php');
@set_time_limit(0);
$mysqlversion = vB::getDbAssertor()->getRow('mysqlVersion');
define('MYSQL_VERSION', $mysqlversion['version']);

$vbphrase = vB_Api::instanceInternal('phrase')->fetch(array(
		'note_reindexing_empty_indexes_x', 'building_search_index', 'default', 'empty_the_index', 'fetching_x_nodes',
		'indexing_x_nodes', 'indexing_from_x_to_y_in_z', 'indexing_x_nodes_took_y', 'fetching_parent_nodes_for_attachments', 'indexing_parent_nodes',
		'indexing_parents_took_x', 'indexing_rest_of_contenttypes', 'indexing_from_x_to_y'
));
echo(strip_tags($vbphrase['note_reindexing_empty_indexes_x']) . "\n");
$emptyindex = intval(readline($vbphrase['empty_index'].' [0/1,'.$vbphrase['default'].'=0]: '));

echo("\n");
$params = array('contenttypeid' => vB_Api::instanceInternal('ContentType')->fetchContentTypeIdFromClass('Text'));
$searchAPI = vB_Api::instanceInternal('search');
$start = time();

if ($emptyindex)
{
	$startbatch = time();
	echo($vbphrase['empty_the_index'] . '...');
	$searchAPI->emptyIndex();
	$endbatch = time();
	$table = 'vBDBSearch:textToIndex';
	echo(fetch_postindex_exec_time($endbatch-$startbatch) . "\n");
}
else
{
	$table = 'vBDBSearch:textToIndexEmptyCRC32';
}

$perpage = 1000;

$params = array('contenttypeid' => vB_Api::instanceInternal('ContentType')->fetchContentTypeIdFromClass('Text'));

// first we index the text nodes with a direct approach, skipping a few API calls
$count = 1;
$startbatch = time();

echo(vB_Phrase::parsePhrase($vbphrase['fetching_x_nodes'], array('Text')) . '...');
$textNodes = vB::getDbAssertor()->assertQuery($table, $params);
echo (fetch_postindex_exec_time(microtime(true)-$startbatch) . "\n");
echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes'], array('Text')) . "...\n");
$startbatch = time();
$failed = array();
foreach ($textNodes as $node)
{
	if (!($count % $perpage))
	{
		echo(vB_Phrase::parsePhrase($vbphrase['indexing_from_x_to_y_in_z'], array($count - $perpage, $count, fetch_postindex_exec_time(time()-$startbatch))) . "\n");
		$startbatch = time();
		if (!empty($failed))
		{
			echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
			$failed = array();
		}
	}
	try
	{
		$searchAPI->indexText($node, $node['title'], $node['rawtext'], true);
	}
	catch (Exception $e)
	{
		$failed[] = $node['nodeid'];
	}

	$count++;
}

if (!empty($failed))
{
	echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
	$failed = array();
}

echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes_took_y'], array('Text', fetch_postindex_exec_time(microtime(true)-$start))) . "\n");

unset($textNodes);

// now we index the channel nodes with a direct approach, skipping a few API calls
$startchannel = microtime(true);
$params = array('contenttypeid' => vB_Api::instanceInternal('ContentType')->fetchContentTypeIdFromClass('Channel'));
$startbatch = time();
echo(vB_Phrase::parsePhrase($vbphrase['fetching_x_nodes'], array('Channel')) . '...');

$channelNodes = vB::getDbAssertor()->assertQuery('vBForum:node', $params);
echo (fetch_postindex_exec_time(microtime(true)-$startbatch) . "\n");
echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes'], array('Channel')) . "...\n");
$startbatch = time();

$count = 1;
foreach ($channelNodes as $node)
{
	if (!($count % $perpage))
	{
		echo(vB_Phrase::parsePhrase($vbphrase['indexing_from_x_to_y_in_z'], array($count - $perpage, $count, fetch_postindex_exec_time(time()-$startbatch))) . "\n");
		$startbatch = time();
		if (!empty($failed))
		{
			echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
			$failed = array();
		}
	}
	try
	{
		$searchAPI->indexText($node, $node['title'], $node['rawtext'], true);
	}
	catch (Exception $e)
	{
		$failed[] = $node['nodeid'];
	}

	$count++;
}

if (!empty($failed))
{
	echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
	$failed = array();
}

echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes_took_y'], array('Channel', fetch_postindex_exec_time(microtime(true)-$startchannel))) . "\n");
unset($channelNodes);


// index the attach nodes with a direct approach, skipping a few API calls
$params = array('contenttypeid' => vB_Api::instanceInternal('ContentType')->fetchContentTypeIdFromClass('Attach'));
$count = 1;
$startbatch = $startAttachAll = time();
echo(vB_Phrase::parsePhrase($vbphrase['fetching_x_nodes'], array('Attach')) . '...');
$attachNodes = vB::getDbAssertor()->assertQuery('vBDBSearch:fetchAttachments', $params);
echo (fetch_postindex_exec_time(microtime(true)-$startbatch) . "\n");
echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes'], array('Attach')) . "...\n");
$startbatch = time();
$parents = array();
foreach ($attachNodes as $node)
{
	if (!($count % $perpage))
	{
		echo(vB_Phrase::parsePhrase($vbphrase['indexing_from_x_to_y_in_z'], array($count - $perpage, $count, fetch_postindex_exec_time(time()-$startbatch))) . "\n");
		$startbatch = time();
		if (!empty($failed))
		{
			echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
			$failed = array();
		}
	}
	$text = trim($node['caption'] . ' ' . $node['filename']);
	if (!empty($text))
	{
		if (empty($parents[$node['nodeid']]))
		{
			$parents[$node['nodeid']] = '';
		}
		$parents[$node['nodeid']] .= $text;
	}
	try
	{
		$searchAPI->indexText($node, $text, $node['parenttitle'], true);
	}
	catch (Exception $e)
	{
		$failed[] = $node['nodeid'];
	}

	$count++;
}

if (!empty($failed))
{
	echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
	$failed = array();
}

// need to index the nodes the attachments belong to
$count = 1;
$startbatch = time();
echo($vbphrase['fetching_parent_nodes_for_attachments']);
$textNodes = vB::getDbAssertor()->assertQuery('vBForum:node', array('nodeid' => array_keys($parents)));
echo (fetch_postindex_exec_time(microtime(true)-$startbatch) . "\n");
echo($vbphrase['indexing_parent_nodes'] . "\n");
$startbatch = $startAttach = time();
foreach ($textNodes as $node)
{
	if (!($count % $perpage))
	{
		echo(vB_Phrase::parsePhrase($vbphrase['indexing_from_x_to_y_in_z'], array($count - $perpage, $count, fetch_postindex_exec_time(time()-$startbatch))) . "\n");
		$startbatch = time();
		if (!empty($failed))
		{
			echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
			$failed = array();
		}
	}
	try
	{
		$searchAPI->indexText($node, $node['title'], $node['rawtext'] . ' ' . $parents[$node['nodeid']], true);
	}
	catch (Exception $e)
	{
		$failed[] = $node['nodeid'];
	}

	$count++;
}

if (!empty($failed))
{
	echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
	$failed = array();
}

echo(vB_Phrase::parsePhrase($vbphrase['indexing_parents_took_x'], array(fetch_postindex_exec_time(microtime(true)-$startAttach))) . "\n");
unset($textNodes);
$startchannel = microtime(true);
// now we index the channel nodes with a direct approach, skipping a few API calls

echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes_took_y'], array('Attach', fetch_postindex_exec_time(microtime(true)-$startAttachAll))) . "\n");
unset($attachNodes);

$params = array('contenttypeid' => vB_Api::instanceInternal('ContentType')->fetchContentTypeIdFromClass('PrivateMessage'));
// first we index the text nodes with a direct approach, skipping a few API calls
$count = 1;
$startbatch = $startPM = time();
echo(vB_Phrase::parsePhrase($vbphrase['fetching_x_nodes'], array('PrivateMessage')) . '...');
$privateMessageNodes = vB::getDbAssertor()->assertQuery($table, $params);
echo (fetch_postindex_exec_time(microtime(true)-$startbatch) . "\n");
echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes'], array('PrivateMessage')) . "...\n");
$startbatch = time();
foreach ($privateMessageNodes as $node)
{
	if (!($count % $perpage))
	{
		echo(vB_Phrase::parsePhrase($vbphrase['indexing_from_x_to_y_in_z'], array($count - $perpage, $count, fetch_postindex_exec_time(time()-$startbatch))) . "\n");
		$startbatch = time();
		if (!empty($failed))
		{
			echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
			$failed = array();
		}
	}
	try
	{
		$searchAPI->indexText($node, $node['title'], $node['rawtext'], true);
	}
	catch (Exception $e)
	{
		$failed[] = $node['nodeid'];
	}

	$count++;
}

if (!empty($failed))
{
	echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
	$failed = array();
}

echo(vB_Phrase::parsePhrase($vbphrase['indexing_x_nodes_took_y'], array('PrivateMessage', fetch_postindex_exec_time(microtime(true)-$startPM))) . "\n");
unset($textNodes);

//the remaining contenttypes will be indexed using the regular index
$params = array(
		vB_Db_Query::PARAM_LIMIT => $perpage,
		vB_dB_Query::CONDITIONS_KEY => array(
							array('field' => 'contenttypeid', 'value' => vB_Api::instanceInternal('ContentType')->fetchContentTypeIdFromClass('Text'), 'operator' => vB_dB_Query::OPERATOR_NE),
							array('field' => 'CRC32', 'value' => '', 'operator' => vB_dB_Query::OPERATOR_EQ)
						)
		);
// we will only index the nodes that have not been indexed before
$offset = 0;
echo($vbphrase['indexing_rest_of_contenttypes'] . "\n");
do
{
	$count = 0;
	$startbatch = time();

	echo(vB_Phrase::parsePhrase($vbphrase['indexing_from_x_to_y'], array($offset, $offset + $perpage)) . "...");
	$params[vB_Db_Query::PARAM_LIMITSTART] = $offset;
	$textNodes = vB::getDbAssertor()->assertQuery('vBForum:node', $params);
	foreach ($textNodes as $node)
	{
		try
		{
			$searchAPI->index($node, 0);
		}
		catch (Exception $e)
		{
			$failed[] = $node['nodeid'];
		}

		$count++;
	}

	if (!empty($failed))
	{
		echo(vB_Phrase::parsePhrase($vbphrase['indexing_failed_for_x'], array(implode(',', $failed))) . "\n");
		$failed = array();
	}

	$offset += $perpage;
	$endbatch = time();
	echo(fetch_postindex_exec_time($endbatch-$startbatch) . "\n");
}
while($count > 0);

$end = microtime(true);
echo($vbphrase['building_search_index'] . ': ' . fetch_postindex_exec_time($end-$start) . "\n");

/*======================================================================*\
|| ####################################################################
|| # CVS: $RCSfile$ - $Revision: 36398 $
|| ####################################################################
\*======================================================================*/
?>
