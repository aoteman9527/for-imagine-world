<?php
/**
*
* @package acp
* @version $Id$
* @copyright (c) 2005 phpBB Group
* @license http://opensource.org/licenses/gpl-license.php GNU Public License
*
*/

/**
* @package module_install
*/
class acp_my_users_info
{
	function module()
	{
		return array(
			'filename'	=> 'acp_my_users',
			'title'		=> 'ACP_USER_MANAGEMENT',
			'version'	=> '1.0.0',
			'modes'		=> array(
				'avatar'		=> array('title' => 'ACP_USER_AVATAR', 'auth' => 'acl_a_user', 'display' => false, 'cat' => array('ACP_CAT_USERS')),
			),
		);
	}

	function install()
	{
	}

	function uninstall()
	{
	}
}

?>