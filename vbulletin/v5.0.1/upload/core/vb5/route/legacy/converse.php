<?php

/* ======================================================================*\
  || #################################################################### ||
  || # vBulletin 5.0.1
  || # ---------------------------------------------------------------- # ||
  || # Copyright ©2000-2013 vBulletin Solutions Inc. All Rights Reserved. ||
  || # This file may not be redistributed in whole or significant part. # ||
  || # ---------------- VBULLETIN IS NOT FREE SOFTWARE ---------------- # ||
  || # http://www.vbulletin.com | http://www.vbulletin.com/license.html # ||
  || #################################################################### ||
  \*====================================================================== */

class vB5_Route_Legacy_Converse extends vB5_Route_Legacy_Member
{
	/**
	 * The name of the script that the URL links to.
	 *
	 * @var string
	 */
	protected $script = 'member.php';
	
	public function getPrefix()
	{
		return 'converse.php';
	}
	
	public function getRegex()
	{
		return $this->getPrefix();
	}
}

/*======================================================================*\
|| ####################################################################
|| # CVS: $RCSfile$ - $Revision: 40911 $
|| ####################################################################
\*======================================================================*/