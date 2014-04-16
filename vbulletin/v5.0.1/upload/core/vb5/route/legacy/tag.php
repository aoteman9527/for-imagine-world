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

class vB5_Route_Legacy_Tag extends vB5_Route_Legacy
{
	/**
	 * The request variable for the resource id.
	 *
	 * @var string
	 */
	protected $idvar = 'tag';

	/**
	 * Link info index of the resource id.
	 *
	 * @var string
	 */
	protected $idkey = '';

	/**
	 * Link info index of the title.
	 *
	 * @var string
	 */
	protected $titlekey = '';

	/**
	 * Array of pageinfo vars to ignore when building the uri.
	 *
	 * @var array string
	 */
	protected $ignorelist = array('tag');

	/**
	 * The name of the script that the URL links to.
	 *
	 * @var string
	 */
	protected $script = 'tags.php';
	protected $script_base_option_name = 'vbforum_url';

	/**
	 * The segment of the uri that identifies this type.
	 *
	 * @var string
	 */
	protected $rewrite_segment = 'tags';
	
	public function getPrefix()
	{
		return 'tags.php';
	}
	
	public function getRegex()
	{
		return $this->getPrefix();
	}
	
	protected function getNewRouteInfo($oldid)
	{
		return array('tag' => $oldid);
	}

	protected function setNewRoute($routeInfo)
	{
		$this->queryParameters['searchJSON'] = "{\"tag\":[\"{$routeInfo['tag']}\"]}";

		return 'search';
	}
}

/*======================================================================*\
|| ####################################################################
|| # CVS: $RCSfile$ - $Revision: 40911 $
|| ####################################################################
\*======================================================================*/