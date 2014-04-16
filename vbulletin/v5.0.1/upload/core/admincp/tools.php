<?php
/*======================================================================*\
|| #################################################################### ||
|| # vBulletin 5.0.1
|| # ---------------------------------------------------------------- # ||
|| # Copyright ©2000-2013 vBulletin Solutions Inc. All Rights Reserved. ||
|| # This file may not be redistributed in whole or significant part. # ||
|| # ---------------- VBULLETIN IS NOT FREE SOFTWARE ---------------- # ||
|| # http://www.vbulletin.com | http://www.vbulletin.com/license.html # ||
|| #################################################################### ||
\*======================================================================*/

error_reporting(E_ALL & ~E_NOTICE);

define('VERSION', '5.0.1');
define('THIS_SCRIPT', 'tools.php');
define('VB_AREA', 'tools');
define('VB_ENTRY', 1);


$core = realpath(dirname(__FILE__) . '/../');
if (file_exists($core . '/includes/init.php'))
{ // need to go up a single directory, we must be in includes / admincp / modcp / install
	chdir($core);
}
else
{
	die('Please place this file within the "core/admincp" / "core/install" folder');
}

require_once( './install/includes/class_upgrade.php');
require_once('./install/init.php');
require_once(DIR . '/includes/functions.php');
require_once(DIR . '/includes/adminfunctions.php');

$vb5_config =& vB::getConfig();
$options = vB::getDatastore()->getValue('options');

$type = $vbulletin->input->clean_gpc('r', 'type', vB_Cleaner::TYPE_STR);
vB_Upgrade::createAdminSession();

#####################################
# phrases for import systems
#####################################
$vbphrase['importing_language'] = 'Importing Language';
$vbphrase['importing_style'] = 'Importing Style';
$vbphrase['importing_admin_help'] = 'Importing Admin Help';
$vbphrase['importing_settings'] = 'Importing Setting';
$vbphrase['please_wait'] = 'Please Wait';
$vbphrase['language'] = 'Language';
$vbphrase['master_language'] = 'Master Language';
$vbphrase['admin_help'] = 'Admin Help';
$vbphrase['style'] = 'Style';
$vbphrase['styles'] = 'Styles';
$vbphrase['settings'] = 'Settings';
$vbphrase['master_style'] = 'MASTER STYLE';
$vbphrase['templates'] = 'Templates';
$vbphrase['css'] = 'CSS';
$vbphrase['stylevars'] = 'Stylevars';
$vbphrase['replacement_variables'] = 'Replacement Variables';
$vbphrase['controls'] = 'Controls';
$vbphrase['rebuild_style_information'] = 'Rebuild Style Information';
$vbphrase['updating_style_information_for_each_style'] = 'Updating style information for each style';
$vbphrase['updating_styles_with_no_parents'] = 'Updating style sets with no parent information';
$vbphrase['updated_x_styles'] = 'Updated %1$s Styles';
$vbphrase['no_styles_needed_updating'] = 'No Styles Needed Updating';
$vbphrase['processing_complete_proceed'] = 'Processing Complete - Proceed';

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>vBulletin Tools</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" href="../core/cpstyles/vBulletin_5_Default/controlpanel.css" />
	<script type="text/javascript">
		var SESSIONHASH = "";
		var toggleAllCheckboxesInForm = function(ctrl)
		{
			var i, el;
			for (i = 0; i < ctrl.form.elements.length; i++)
			{
				el = ctrl.form.elements[i];
				if (el.type == 'checkbox' && el != ctrl)
				{
					el.checked = ctrl.checked;
				}
			}
		};

	</script>
	<!-- script type="text/javascript" src="../clientscript/vbulletin_global.js"></script -->


</head>
<body style="margin:0px">
<div class="acp-content-wrapper">
<h2 class="pagetitle" style="text-align:center">vBulletin 5 Tools</h2>
<!-- END CONTROL PANEL HEADER -->
<?php


if (empty($_REQUEST['do']))
{
	function getXmlVersion($file, $read, $regex)
	{
		// Get versions of .xml files for header diagnostics
		if ($fp = @fopen('./install/' . $file, 'rb'))
		{
			$data = fread($fp, $read);
			if (preg_match($regex, $data, $matches))
			{
				$version = $matches[1];
			}
			else
			{
				$version = 'Unknown';
			}
			fclose($fp);
		}
		else
		{
			$version = 'N/A';
		}

		return $version;
	}

	$style_xml = getXmlVersion('vbulletin-style.xml', 256, '#vbversion="(.*?)"#');
	$language_xml = getXmlVersion('vbulletin-language.xml', 256, '#vbversion="(.*?)"#');
	$settings_xml = getXmlVersion('vbulletin-settings.xml', 300, '#<defaultvalue>(.*?)</defaultvalue>#');

	$language = $db->query_read('SELECT title FROM ' . TABLE_PREFIX . 'language WHERE languageid = ' . intval($options['languageid']));
	if ($db->num_rows($language) == 1)
	{
		$language = $db->fetch_array($language);
		$language = $language['title'];
	}
	else
	{
		$language = 'Unknown';
	}

	print_form_header();

	print_table_header('Import XML Files');
	print_column_style_code(array('width:30%'));
	print_label_row(construct_link_code('Style', THIS_SCRIPT . '?do=xml&amp;type=style'), "This will take the latest style from ./install/vbulletin-style.xml<dfn>Version: <b>$style_xml</b></dfn>");
	print_label_row(construct_link_code('Settings', THIS_SCRIPT . '?do=xml&amp;type=settings'), "This will take the latest settings from ./install/vbulletin-settings.xml<dfn>Version: <b>$settings_xml</b></dfn>");
	print_label_row(construct_link_code('Language', THIS_SCRIPT . '?do=xml&amp;type=language'), "This will take the latest language from ./install/vbulletin-language.xml<dfn>Version: <b>$language_xml</b></dfn>");
	print_label_row(construct_link_code('Admin Help', THIS_SCRIPT . '?do=xml&amp;type=adminhelp'), 'This will take the latest admin help from ./install/vbulletin-adminhelp.xml');
	print_table_break();

	print_table_header('Datastore Cache');
	print_column_style_code(array('width:30%'));
	print_label_row(construct_link_code('Usergroup / Channel Cache', THIS_SCRIPT . '?do=cache&amp;type=channel'), 'Update the channel and usergroup cache');
	print_label_row(construct_link_code('Options Cache', THIS_SCRIPT . '?do=cache&amp;type=options'), 'Update the options cache from the setting table');
	print_label_row(construct_link_code('Bitfield Cache', THIS_SCRIPT . '?do=bitfields'), 'Update the bitfields cache from the xml/bitfields_<em>???</em>.xml files');
	print_table_break();

	print_table_header('Cookies');
	print_column_style_code(array('width:30%'));
	$options['cookiedomain'] = $options['cookiedomain'] == '' ? ' ( blank ) ' : '<b>' . htmlspecialchars_uni($options['cookiedomain']) . '</b>';
	$options['cookiepath'] = $options['cookiepath'] == '' ? ' ( blank ) ' : '<b>' . htmlspecialchars_uni($options['cookiepath']) . '</b>';
	print_label_row('Cookie Prefix', '<b>' . htmlspecialchars_uni(COOKIE_PREFIX) . '</b> (<em>set in includes/config.php</em>)');
	print_label_row(construct_link_code('Reset Cookie Domain', THIS_SCRIPT . '?do=cookie&amp;type=domain'), 'Reset the cookie domain to be blank<dfn>Currently: ' . $options['cookiedomain'] . '</dfn>');
	print_label_row(construct_link_code('Reset Cookie Path', THIS_SCRIPT . '?do=cookie&amp;type=path'), 'Reset the cookie path to be <b>/</b><dfn>Currently: ' . $options['cookiepath'] . '</dfn>');
	print_table_break();

	print_table_header('MySQL');
	print_column_style_code(array('width:30%'));
	print_label_row(construct_link_code('Run Query', THIS_SCRIPT . '?do=mysql&amp;type=query'), 'This allows you to run alter and update queries on the database');
	print_label_row(construct_link_code('Repair Tables', THIS_SCRIPT . '?do=mysql&amp;type=repair'), 'You can select tables that need repaired here');
	print_label_row(construct_link_code('Reset Admin Access', THIS_SCRIPT . '?do=user&amp;type=access'), 'Reset admin access for a user');
	print_table_break();

	$randnumb = vbrand(0, 100000000);
	print_table_header('Other Tools');
	print_column_style_code(array('width:30%'));
	print_label_row(construct_link_code($options['bbactive'] ? 'Turn Off Forum' : 'Turn On Forum', THIS_SCRIPT . '?do=bbactive'), 'Your forum is <b>' . ($options['bbactive'] ? 'On' : 'Off') . '</b>');
	print_label_row(construct_link_code('Default Language', THIS_SCRIPT . '?do=language'), 'Reset board default language.<dfn>Currently: <b>' . htmlspecialchars($language) . '</b></dfn>');
	print_label_row(construct_link_code('Location of Core Directory', THIS_SCRIPT . '?do=bburl'), 'Change location of core directory. (This the vboptions[bburl] setting) <br /><dfn>Currently: <b>' . htmlspecialchars($options['bburl']) . '</b></dfn>');
	print_table_break();

	print_table_header('Time');
	print_column_style_code(array('width:30%'));
	print_label_row('System Time', $systemdate = date('r T'));
	print_label_row('Your Time', $userdate = vbdate('r T'));
	print_table_footer();
}
else if ($_REQUEST['do'] == 'xml')
{
	switch ($vbulletin->GPC['type'])
	{
		case 'style':
			require_once('./includes/adminfunctions_template.php');

			if (!($xml = file_read('./install/vbulletin-style.xml')))
			{
				echo '<p>Uh oh, ./install/vbulletin-style.xml doesn\'t appear to exist! Upload it and refresh the page.</p>';
				print_cp_footer();
			}

			echo '<p>Importing vbulletin-style.xml</p>';

			$startat = $vbulletin->input->clean_gpc('r', 'startat', vB_Cleaner::TYPE_UINT);

			$vbphrase['go_back'] = 'Go Back';
			$vbphrase['template_group_x'] = 'Template Group: %1$s';

			$perpage = 10;
			$imported = xml_import_style($xml, -1, -1, '', false, 1, false, $startat, $perpage);
			if (!$imported['done'])
			{
				//build the next page url;
				$startat = $startat + $perpage;
				print_cp_redirect2('tools', array('do' => 'xml', 'type' => 'style', 'startat' => $startat));
			}
			// define those phrases that are used for the import
			$vbphrase['style'] = 'Style';
			$vbphrase['please_wait'] = 'Please Wait';

			build_all_styles(0, 1);
			print_cp_redirect2('tools', array('do' => 'templatemerge'));
		break;
		case 'settings':
			require_once('./includes/adminfunctions_options.php');

			if (!($xml = file_read('./install/vbulletin-settings.xml')))
			{
				echo '<p>Uh oh, ./install/vbulletin-settings.xml doesn\'t appear to exist! Upload it and refresh the page.</p>';
				print_cp_footer();
			}

			echo '<p>Importing vbulletin-settings.xml';
			xml_import_settings($xml);
			echo '<br /><span class="smallfont"><b>Okay</b></span></p>';
		break;
		case 'language':
			require_once('./includes/adminfunctions_language.php');

			if (!($xml = file_read('./install/vbulletin-language.xml')))
			{
				echo '<p>Uh oh, ./install/vbulletin-language.xml doesn\'t appear to exist! Upload it and refresh the page.</p>';
				print_cp_footer();
			}

			echo '<p>Importing vbulletin-language.xml';
			xml_import_language($xml);
			build_language();
			echo '<br /><span class="smallfont"><b>Okay</b></span></p>';
		break;
		case 'adminhelp':
			require_once('./includes/adminfunctions_help.php');

			if (!($xml = file_read('./install/vbulletin-adminhelp.xml')))
			{
				echo '<p>Uh oh, ./install/vbulletin-adminhelp.xml doesn\'t appear to exist! Upload it and refresh the page.</p>';
				print_cp_footer();
			}

			echo '<p>Importing vbulletin-adminhelp.xml';
			xml_import_help_topics($xml);
			echo "<br /><span class=\"smallfont\"><b>Okay</b></span></p>";
		break;
	}
	define('SCRIPT_REDIRECT', true);
}
else if ($_REQUEST['do'] == 'templatemerge') // after importing style
{
	$vbulletin->input->clean_array_gpc('r', array(
		'startat' => vB_Cleaner::TYPE_UINT,
	));

	require_once(DIR . '/includes/class_template_merge.php');

	$merge_data = new vB_Template_Merge_Data($vbulletin);
	$merge_data->start_offset = $vbulletin->GPC['startat'];
	$merge_data->add_condition("tnewmaster.product IN ('', 'vbulletin')");

	$merge = new vB_Template_Merge($vbulletin);
	$merge->time_limit = 5;
	$completed = $merge->merge_templates($merge_data, $output);

	if ($completed)
	{
		// completed
		$vbphrase['style'] = 'Style';
		$vbphrase['please_wait'] = 'Please Wait';

		build_all_styles();

		define('SCRIPT_REDIRECT', true);
	}
	else
	{
		// more templates to merge
		print_cp_redirect2('tools', array('do' => 'templatemerge', 'startat' => ($merge_data->start_offset + $merge->fetch_processed_count())));
	}
}
else if ($_REQUEST['do'] == 'cache')
{
	switch ($vbulletin->GPC['type'])
	{
		case 'channel':
			build_channel_permissions();
			define('SCRIPT_REDIRECT', true);
		break;
		case 'options':
			vB::getDatastore()->build_options();
			define('SCRIPT_REDIRECT', true);
		break;
	}
}
else if ($_REQUEST['do'] == 'cookie')
{
	switch ($vbulletin->GPC['type'])
	{
		case 'domain':
			$db->query_write("
				UPDATE " . TABLE_PREFIX . "setting
				SET value = ''
				WHERE varname = 'cookiedomain'
			");
			vB::getDatastore()->build_options();
			define('SCRIPT_REDIRECT', true);
		break;
		case 'path':
			$db->query_write("
				UPDATE " . TABLE_PREFIX . "setting
				SET value = '/'
				WHERE varname = 'cookiepath'
			");
			vB::getDatastore()->build_options();
			define('SCRIPT_REDIRECT', true);
		break;
	}
}
else if ($_REQUEST['do'] == 'bitfields')
{
	require_once(DIR . '/includes/class_bitfield_builder.php');
	vB_Bitfield_Builder::save($db);
	build_channel_permissions();
	define('SCRIPT_REDIRECT', true);
}
else if ($_REQUEST['do'] == 'mysql')
{
	$vbulletin->input->clean_array_gpc('p', array('query' => vB_Cleaner::TYPE_STR, 'tables' => vB_Cleaner::TYPE_ARRAY));

	switch ($vbulletin->GPC['type'])
	{
		case 'query':
			if (empty($vbulletin->GPC['query']) OR !preg_match('#^(Alter|Update)#si', $vbulletin->GPC['query']))
			{
				print_form_header('tools', 'mysql');
				construct_hidden_code('type', 'query');
				print_table_header('Please paste alter / update query below');
				print_textarea_row('Query to run', 'query','', 6, 60, 0, 0);
				print_submit_row('Run', '');
			}
			else
			{
				$db->query_write($vbulletin->GPC['query']);
				define('SCRIPT_REDIRECT', true);
			}
			break;
		case 'repair':
			if (empty($vbulletin->GPC['tables']))
			{
				print_form_header('tools', 'mysql');
				construct_hidden_code('type', 'repair');
				print_table_header('Please select tables to repair');
				print_label_row('Table', "<label><input type=\"checkbox\" name=\"allbox\" title=\"Check All\" onclick=\"toggleAllCheckboxesInForm(this);\" />Check All</label>", 'thead');
				$result = $db->query_write("SHOW TABLE STATUS");
				while ($currow = $db->fetch_array($result, vB_Database::DBARRAY_NUM))
				{
					if (!in_array(strtolower($currow[1]), array('heap', 'memory')))
					{
						print_checkbox_row($currow[0], "tables[$currow[0]]", 0);
					}
				}
				print_submit_row('Repair', '');
			}
			else
			{
				echo '<ul>';
				foreach($vbulletin->GPC['tables'] AS $key => $val)
				{
					if ($val == 1)
					{
						echo "<li>Repairing <b>$key</b>... ";
						flush();
						$db->query_write("REPAIR TABLE $key");
						echo "Repair Complete</li>\n";
					}
				}
				echo '</ul>';
				echo "<p>Overall Repair complete</p><br />";
				define('SCRIPT_REDIRECT', true);
			}
		break;
	}
}
else if ($_REQUEST['do'] == 'user')
{
	$vbulletin->input->clean_array_gpc('p', array('user' => vB_Cleaner::TYPE_STR));

	switch ($vbulletin->GPC['type'])
	{
		case 'access':
		if (empty($vbulletin->GPC['user']))
		{
			print_form_header('tools', 'user');
			construct_hidden_code('type', 'access');
			print_table_header('Enter username to restore access to');
			print_input_row('User Name', 'user', '');
			print_submit_row('Submit', '');
		}
		else
		{
			$userid = $db->query_first("SELECT userid, usergroupid FROM " . TABLE_PREFIX . "user WHERE username = '" . $db->escape_string(htmlspecialchars_uni($vbulletin->GPC['user'])) . "'");
			if (empty($userid['userid']))
			{
				echo '<p align="center">Invalid username</p>';
			}
			else
			{
				// let's check that usergroupid 6 is still admin
				$bf_ugp_adminpermissions = vB::getDatastore()->get_value('bf_ugp_adminpermissions');
				$ugroup = $db->query_first("SELECT * FROM " . TABLE_PREFIX . "usergroup WHERE usergroupid = 6 AND (adminpermissions & " . $bf_ugp_adminpermissions['cancontrolpanel'] . ")");
				if (empty($ugroup['usergroupid']))
				{ // lets give them admin permissions again
					$db->query_write("UPDATE " . TABLE_PREFIX . "usergroup SET adminpermissions = 3 WHERE usergroupid = 6");
					build_channel_permissions();
				}
				/*insert query*/
				$db->query_write("REPLACE INTO " . TABLE_PREFIX . "administrator
					(userid, adminpermissions)
				VALUES
					($userid[userid], " . (array_sum($bf_ugp_adminpermissions) - 3) . ")
				");
				$db->query_write("UPDATE " . TABLE_PREFIX . "user SET usergroupid = 6 WHERE userid = $userid[userid]");
				define('SCRIPT_REDIRECT', true);

				vB_Cache::instance(vB_Cache::CACHE_FAST)->event('perms_changed');
				vB_Cache::instance(vB_Cache::CACHE_FAST)->event('userChg_' . $userid['userid']);
				vB_Cache::instance(vB_Cache::CACHE_LARGE)->event('userChg_' . $userid['userid']);
				vB::getUserContext()->rebuildGroupAccess();
			}
		}
		break;
	}
}
else if ($_REQUEST['do'] == 'bbactive')
{
	$db->query_write("
		UPDATE " . TABLE_PREFIX . "setting
		SET value = " . ($options['bbactive'] ? 0 : 1) . "
		WHERE varname = 'bbactive'
	");
	vB::getDatastore()->build_options();
	define('SCRIPT_REDIRECT', true);
}
else if ($_REQUEST['do'] == 'language')
{
	$vbulletin->input->clean_array_gpc('p', array('languageid' => vB_Cleaner::TYPE_UINT));

	require_once(DIR . '/includes/adminfunctions_language.php');

	$languages = $db->query_read('SELECT * FROM ' . TABLE_PREFIX . 'language');
	if ($db->num_rows($languages) == 0)
	{
		// this is just taken from install.php
		$db->query_write("INSERT INTO " . TABLE_PREFIX . "language (title, languagecode, charset, decimalsep, thousandsep) VALUES ('English (US)', 'en', 'ISO-8859-1', '.', ',')");
		$_languageid = $db->insert_id();

		$db->query_write("
			UPDATE " . TABLE_PREFIX . "setting
			SET value = " . $_languageid . "
			WHERE varname = 'languageid'
		");

		$db->query_write("
			UPDATE " . TABLE_PREFIX . "user
			SET languageid = 0
		");
		vB::getDatastore()->build_options();
		build_language($_languageid);
		build_language_datastore();
		define('SCRIPT_REDIRECT', true);
	}
	else
	{
		$sellanguages = array();
		while ($language = $db->fetch_array($languages))
		{
			$sellanguages[$language['languageid']] = $language['title'];
		}

		$languageids = implode(',', array_keys($sellanguages));

		$db->query_write("
			UPDATE " . TABLE_PREFIX . "user
			SET languageid = 0
			WHERE languageid NOT IN ($languageids)
		");

		if (empty($vbulletin->GPC['languageid']))
		{
			print_form_header('tools', 'language');
			print_table_header('Select the new default language');
			print_select_row('Language', 'languageid', $sellanguages, $options['languageid']);
			print_submit_row('Submit', '');
		}
		else
		{
			vB_Api::instanceInternal('language')->setDefault($vbulletin->GPC['languageid']);
			//$db->query_write("
			//	UPDATE " . TABLE_PREFIX . "setting
			//	SET value = " . $vbulletin->GPC['languageid'] . "
			//	WHERE varname = 'languageid'
			//");
			//vB::getDatastore()->build_options();
			//build_language($vbulletin->GPC['languageid']);
			//build_language_datastore();
			define('SCRIPT_REDIRECT', true);
		}
	}
}
else if ($_REQUEST['do'] == 'bburl')
{
	$vbulletin->input->clean_array_gpc('p', array('bburl' => vB_Cleaner::TYPE_STR));

	if (empty($vbulletin->GPC['bburl']))
	{
		print_form_header('tools', 'bburl');
		print_table_header('Enter the new core directory location (bburl)');
		print_input_row('Core directory location (bburl).<br />Note: do not add a trailing slash. (\'/\')', 'bburl', htmlspecialchars($options['bburl']));
		print_submit_row('Submit', '');
	}
	else
	{
		$db->query_write("
			UPDATE " . TABLE_PREFIX . "setting
			SET value = '" . $db->escape_string($vbulletin->GPC['bburl']) . "'
			WHERE varname = 'bburl'
		");
		vB::getDatastore()->build_options();
		define('SCRIPT_REDIRECT', true);
	}
}

if (defined('SCRIPT_REDIRECT'))
{
	$vbphrase['redirecting'] = empty($vbphrase['redirecting']) ? 'Redirecting' : $vbphrase['redirecting'];
	echo '<p align="center" class="smallfont"><a href="tools.php" onclick="javascript:clearTimeout(timerID);">' . $vbphrase['processing_complete_proceed'] . '</a></p>';
	echo '<p align="center">' . $vbphrase['redirecting'] . '... (<b id="countdown"></b>)</p>';
	echo "\n<script type=\"text/javascript\">\n";
	echo "myvar = \"\"; timeout = " . (3) . ";
	function exec_refresh()
	{
		document.getElementById('countdown').innerHTML = timeout;
		window.status=\"" . $vbphrase['redirecting'] . "\"+myvar; myvar = myvar + \" .\";
		timerID = setTimeout(\"exec_refresh();\", 1000);
		if (timeout > 0)
		{ timeout -= 1; }
		else { clearTimeout(timerID); window.status=\"\"; window.location=\"tools.php\"; }
	}
	exec_refresh();";
	echo "\n</script>\n";
}

?>
<!-- START CONTROL PANEL FOOTER -->
<p align="center" class="smallfont">vBulletin <?php echo VERSION; ?>, Copyright &copy;2000-<?php echo date('Y'); ?>, vBulletin Solutions Inc.</p>

</div> <!-- acp-content-wrapper -->
</body>
</html>
<?php

/*======================================================================*\
|| ####################################################################
|| # CVS: $RCSfile$ - $Revision: 68490 $
|| ####################################################################
\*======================================================================*/
