<?php
/*======================================================================*\
|| #################################################################### ||
|| # vBulletin 5.0.1
|| # ---------------------------------------------------------------- # ||
|| # Copyright 2000-2013 vBulletin Solutions Inc. All Rights Reserved. ||
|| # This file may not be redistributed in whole or significant part. # ||
|| # ---------------- VBULLETIN IS NOT FREE SOFTWARE ---------------- # ||
|| # http://www.vbulletin.com | http://www.vbulletin.com/license.html # ||
|| #################################################################### ||
\*======================================================================*/

// ######################## SET PHP ENVIRONMENT ###########################
error_reporting(E_ALL & ~E_NOTICE);
$cwd = getcwd();
chdir(pathinfo(__FILE__, PATHINFO_DIRNAME). '/../');

// ##################### DEFINE IMPORTANT CONSTANTS #######################
define('VB_AREA', 'Install');
define('TIMENOW', time());

header('Expires: ' . gmdate("D, d M Y H:i:s", TIMENOW) . ' GMT');
header("Last-Modified: " . gmdate("D, d M Y H:i:s", TIMENOW) . ' GMT');
// ########################## REQUIRE BACK-END ############################
require_once('./install/includes/class_upgrade.php');
require_once('./install/init.php');
//If we're running at the command line we can just run the individual steps. If we're displayed as a web page we need to
// display once at a time.

function confirmNode($node, $channelType, $newLine)
{
	try
	{
		$check = vB_Node::validateRecord($node['nodeid']);

		//if it's not a channel and it's not a starter, we don't care if the counts are off.
		if (($check !== true) AND ($node['contenttypeid'] <> $channelType) AND ($node['starter'] != $node['nodeid'])) {
			//We ignore invalid count and invalid lastxxxx
			foreach ($check['errors'] AS $key => $error) {
				if ((substr($error, 0, 12) == 'invalid last') OR (substr($error, 0, 13) == 'invalid count')) {
					unset($check[$key]);
				}

				if (empty($check)) {
					$check = false;
				}
			}
		}

		if (!$check)
		{
			echo 'node ' . $node['nodeid'] . ' failed: ' . var_export($check, true) . "$newLine";
		}
	}
	catch (Exception $e)
	{
		echo 'Exception ' . $e->getMessage() . ' for node ' . $node['nodeid'] . "$newLine";
	}
}

$channelType = vB_Types::instance()->getContentTypeID('vBForum_Channel');
vB_Upgrade::createAdminSession();

if (empty($_SERVER['HTTP_USER_AGENT']) OR ($_SERVER['HTTP_USER_AGENT'] == 'vB CLI'))
{
	//We're in command line mode
	$nodeQuery = vB::getDbAssertor()->assertQuery('vBForum:node', array(), 'nodeid');
	vB_Upgrade::createAdminSession();
	foreach ($nodeQuery AS $node)
	{
		confirmNode($node, $channelType, "\n");
	}
}
else
{
	if (isset($_REQUEST) AND isset($_REQUEST['startat']))
	{
			$startat = intval($_REQUEST['startat']);
	}
	else
	{
		$startat = 0;
	}
	$nodeQuery = vB::getDbAssertor()->assertQuery('vBForum:node', array(vB_dB_Query::CONDITIONS_KEY => array(
		array('field' => 'nodeid', 'value' => $startat, 'operator' => vB_dB_Query::OPERATOR_GT),
		array('field' => 'nodeid', 'value' => $startat + 500, 'operator' => vB_dB_Query::OPERATOR_LT),
		) ), 'nodeid');

	?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html dir="ltr" lang="en">
<head>
	<title>vBulletin Large Upgrade Preload</title>
	<link rel="stylesheet" href="../cpstyles/vBulletin_5_Silver/controlpanel.css" />
	<style type="text/css">
		#all {
			margin: 10px;
		}
		#all p, #all td, #all li, #all div {
			font-size: 11px;
			font-family: verdana, arial, helvetica, sans-serif;
		}
	</style>
</head>
<body>
<table cellpadding="4" cellspacing="0" border="0" width="100%" class="navbody" style="border:outset 2px">
	<tr>
		<td width="160"><img src="../cpstyles/vBulletin_5_Silver/cp_logo.png" alt="" title="&copy;2000 - 2012 vBulletin Solutions, Inc." /></td>
		<td style="padding-left:100px">
			<b>Validating nodes beginning at <?php echo $startat ?></b><br />
			This may take some time.  Errors will be shown below.<br />
			<br />
	</tr>
</table>
<h3><?php
if ($nodeQuery->valid())
{
	$count = 0;
	foreach($nodeQuery AS $node)
	{
		$count++;
		$startat = $node['nodeid'];
		confirmNode($node, $channelType, "<br />\n");
		if ($node['contenttypeid'] == $channelType)
		{
			break;
		}
	}
	echo "<h3> Checked $count node(s) successfully.</h3>"
	?>
<p align="center">vBulletin v5.0.0, Copyright &copy;2012 - 2013, vBulletin Solutions, Inc.</p>
</body>
<script type="text/javascript">
	setTimeout(function(){document.location = './validatenodes.php?startat=<?php echo $startat?>'}, 5000)
</script>
<?php
}
else
{
	echo "<h2>Validation Complete</h2>";
}
?>

</html>
<?php
}


/*======================================================================*\
|| ####################################################################
|| # CVS: $RCSfile$ - $Revision: 32287 $
|| ####################################################################
\*======================================================================*/
