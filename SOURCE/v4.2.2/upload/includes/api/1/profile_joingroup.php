<?php
/*======================================================================*\
|| #################################################################### ||
|| # vBulletin 4.2.2 - Licence Number VBFRD8D65H
|| # ---------------------------------------------------------------- # ||
|| # Copyright �2000-2013 vBulletin Solutions Inc. All Rights Reserved. ||
|| # This file may not be redistributed in whole or significant part. # ||
|| # ---------------- VBULLETIN IS NOT FREE SOFTWARE ---------------- # ||
|| # http://www.vbulletin.com | http://www.vbulletin.com/license.html # ||
|| #################################################################### ||
\*======================================================================*/
if (!VB_API) die;

$VB_API_WHITELIST = array(
	'response' => array(
		'HTML' => array(
			'groupleaders',
			'usergroup' => array(
				'title'
			),
			'usergroupid'
		)
	),
	'show' => array()
);

/*======================================================================*\
|| ####################################################################
|| # Downloaded: 08:03, Fri Mar 14th 2014
|| # CVS: $RCSfile$ - $Revision: 35584 $
|| ####################################################################
\*======================================================================*/