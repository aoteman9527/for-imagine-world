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

class vB5_Route_Legacy_Member extends vB5_Route_Legacy
{
	/**
	 * The request variable for the resource id.
	 *
	 * @var string
	 */
	protected $idvar = 'u';

	/**
	 * Link info index of the resource id.
	 *
	 * @var string
	 */
	protected $idkey = 'userid';

	/**
	 * Link info index of the title.
	 *
	 * @var string
	 */
	protected $titlekey = 'username';

	/**
	 * Array of pageinfo vars to ignore when building the uri.
	 *
	 * @var array string
	 */
	protected $ignorelist = array('u', 'userid', 'username');

	/**
	 * The name of the script that the URL links to.
	 *
	 * @var string
	 */
	protected $script = 'member.php';
	protected $script_base_option_name = 'vbforum_url';

	/**
	 * The segment of the uri that identifies this type.
	 *
	 * @var string
	 */
	protected $rewrite_segment = 'members';
	
	public function __construct($routeInfo = array(), $matches = array(), $queryString = '')
	{
		// VBV-7499: discard query string parameters excepting userid
		if (!empty($queryString))
		{
			parse_str($queryString, $params);
			
			if (isset($params[$this->idkey]) AND intval($params[$this->idkey]))
			{
				$params = array($this->idkey => $params[$this->idkey]);
			}
			else if (isset($params[$this->idvar]) AND intval($params[$this->idvar]))
			{
				$params = array($this->idvar => $params[$this->idvar]);
			}
			else
			{
				$params = array();
			}
			
			$queryString = http_build_query($params);
		}
		
		parent::__construct($routeInfo, $matches, $queryString);
	}

	protected function getNewRouteInfo($oldid)
	{
		return array('userid' => $oldid);
	}

	protected function setNewRoute($routeInfo)
	{
		$this->arguments['userid'] = $routeInfo['userid'];

		return 'profile';
	}
}

/*======================================================================*\
|| ####################################################################
|| # CVS: $RCSfile$ - $Revision: 40911 $
|| ####################################################################
\*======================================================================*/