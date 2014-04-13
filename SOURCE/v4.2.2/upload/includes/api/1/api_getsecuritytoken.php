<?php
/*======================================================================*\
|| #################################################################### ||
|| # vBulletin Blog 4.2.2 - Licence Number VBFRD8D65H
|| # ---------------------------------------------------------------- # ||
|| # Copyright �2000-2013 vBulletin Solutions Inc. All Rights Reserved. ||
|| # This file may not be redistributed in whole or significant part. # ||
|| # ---------------- VBULLETIN IS NOT FREE SOFTWARE ---------------- # ||
|| # http://www.vbulletin.com | http://www.vbulletin.com/license.html # ||
|| #################################################################### ||
\*======================================================================*/
if (!VB_API) die;

class vB_APIMethod extends vBI_APIMethod
{
	public function output()
	{
		global $vbulletin, $VB_API_REQUESTS;

		if (!$VB_API_REQUESTS['api_s'])
		{
			return $this->error('sessionhash_required', "Sessionhash Required");
		}
		return $vbulletin->userinfo['securitytoken_raw'];
	}
}

/*======================================================================*\
|| ####################################################################
|| # Downloaded: 08:03, Fri Mar 14th 2014
|| # CVS: $RCSfile$ - $Revision: 26995 $
|| ####################################################################
\*======================================================================*/