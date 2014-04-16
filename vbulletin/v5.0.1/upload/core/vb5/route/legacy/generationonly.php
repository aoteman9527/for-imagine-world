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

abstract class vB5_Route_Legacy_GenerationOnly extends vB5_Route_Legacy
{
	protected function getFriendlyUrlMethod()
	{
		// This was a generation only URL, so we always use this method
		return self::FRIENDLY_URL_OFF;
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