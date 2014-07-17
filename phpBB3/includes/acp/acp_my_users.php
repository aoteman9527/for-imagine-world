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
* @ignore
*/
if (!defined('IN_PHPBB'))
{
	exit;
}

/**
* @package acp
*/
class acp_my_users
{
	var $u_action;
	var $p_master;

	function acp_my_users(&$p_master)
	{
		$this->p_master = &$p_master;
	}

	function main($id, $mode)
	{
		global $config, $db, $user, $auth, $template, $cache;
		global $phpbb_root_path, $phpbb_admin_path, $phpEx, $table_prefix, $file_uploads;

		$user->add_lang(array('posting', 'ucp', 'acp/users'));
		$this->tpl_name = 'acp_users';
		$this->page_title = 'ACP_USER_' . strtoupper($mode);

		$error		= array();
		$username	= utf8_normalize_nfc(request_var('username', '', true));
		$user_id	= request_var('u', 0);
		$action		= request_var('action', '');

		$submit		= (isset($_POST['update']) && !isset($_POST['cancel'])) ? true : false;

		$form_name = 'acp_users';
		add_form_key($form_name);

		// Whois (special case)
		if ($action == 'whois')
		{
			include($phpbb_root_path . 'includes/functions_user.' . $phpEx);

			$this->page_title = 'WHOIS';
			$this->tpl_name = 'simple_body';

			$user_ip = request_var('user_ip', '');
			$domain = gethostbyaddr($user_ip);
			$ipwhois = user_ipwhois($user_ip);

			$template->assign_vars(array(
				'MESSAGE_TITLE'		=> sprintf($user->lang['IP_WHOIS_FOR'], $domain),
				'MESSAGE_TEXT'		=> nl2br($ipwhois))
			);

			return;
		}

		// Show user selection mask
		if (!$username && !$user_id)
		{
			$this->page_title = 'SELECT_USER';

			$template->assign_vars(array(
				'U_ACTION'			=> $this->u_action,
				'ANONYMOUS_USER_ID'	=> ANONYMOUS,

				'S_SELECT_USER'		=> true,
				'U_FIND_USERNAME'	=> append_sid("{$phpbb_root_path}memberlist.$phpEx", 'mode=searchuser&amp;form=select_user&amp;field=username&amp;select_single=true'),
			));

			return;
		}

		if (!$user_id)
		{
			$sql = 'SELECT user_id
				FROM ' . USERS_TABLE . "
				WHERE username_clean = '" . $db->sql_escape(utf8_clean_string($username)) . "'";
			$result = $db->sql_query($sql);
			$user_id = (int) $db->sql_fetchfield('user_id');
			$db->sql_freeresult($result);

			if (!$user_id)
			{
				trigger_error($user->lang['NO_USER'] . adm_back_link($this->u_action), E_USER_WARNING);
			}
		}

		// Generate content for all modes
		$sql = 'SELECT u.*, s.*
			FROM ' . USERS_TABLE . ' u
				LEFT JOIN ' . SESSIONS_TABLE . ' s ON (s.session_user_id = u.user_id)
			WHERE u.user_id = ' . $user_id . '
			ORDER BY s.session_time DESC';
		$result = $db->sql_query_limit($sql, 1);
		$user_row = $db->sql_fetchrow($result);
		$db->sql_freeresult($result);

		if (!$user_row)
		{
			trigger_error($user->lang['NO_USER'] . adm_back_link($this->u_action), E_USER_WARNING);
		}

		// Generate overall "header" for user admin
		$s_form_options = '';

		// Build modes dropdown list
		$sql = 'SELECT module_mode, module_auth
			FROM ' . MODULES_TABLE . "
			WHERE module_basename = 'users'
				AND module_enabled = 1
				AND module_class = 'acp'
			ORDER BY left_id, module_mode";
		$result = $db->sql_query($sql);

		$dropdown_modes = array();
		while ($row = $db->sql_fetchrow($result))
		{
			if (!$this->p_master->module_auth($row['module_auth']))
			{
				continue;
			}

			$dropdown_modes[$row['module_mode']] = true;
		}
		$db->sql_freeresult($result);

		foreach ($dropdown_modes as $module_mode => $null)
		{
			$selected = ($mode == $module_mode) ? ' selected="selected"' : '';
			$s_form_options .= '<option value="' . $module_mode . '"' . $selected . '>' . $user->lang['ACP_USER_' . strtoupper($module_mode)] . '</option>';
		}

		$template->assign_vars(array(
			'U_BACK'			=> $this->u_action,
			'U_MODE_SELECT'		=> append_sid("{$phpbb_admin_path}index.$phpEx", "i=$id&amp;u=$user_id"),
			'U_ACTION'			=> $this->u_action . '&amp;u=' . $user_id,
			'S_FORM_OPTIONS'	=> $s_form_options,
			'MANAGED_USERNAME'	=> $user_row['username'])
		);

		// Prevent normal users/admins change/view founders if they are not a founder by themselves
		if ($user->data['user_type'] != USER_FOUNDER && $user_row['user_type'] == USER_FOUNDER)
		{
			trigger_error($user->lang['NOT_MANAGE_FOUNDER'] . adm_back_link($this->u_action), E_USER_WARNING);
		}

		switch ($mode)
		{
			case 'avatar':

				include($phpbb_root_path . 'includes/functions_display.' . $phpEx);
				include($phpbb_root_path . 'includes/functions_user.' . $phpEx);

				$can_upload = (file_exists($phpbb_root_path . $config['avatar_path']) && phpbb_is_writable($phpbb_root_path . $config['avatar_path']) && $file_uploads) ? true : false;
//                echo ($config['avatar_path']."</br>");
//                echo ($file_uploads."</br>");
//                echo ($submit."</br>");
//                print_r($user_row);
//                echo($can_upload."</br>");

                if ($submit)
				{

					if (!check_form_key($form_name))
					{
							trigger_error($user->lang['FORM_INVALID'] . adm_back_link($this->u_action . '&amp;u=' . $user_id), E_USER_WARNING);
					}

					if (avatar_process_user($error, $user_row, $can_upload))
					{
						trigger_error($user->lang['USER_AVATAR_UPDATED'] . adm_back_link($this->u_action . '&amp;u=' . $user_row['user_id']));
					}

					// Replace "error" strings with their real, localised form
					$error = preg_replace('#^([A-Z_]+)$#e', "(!empty(\$user->lang['\\1'])) ? \$user->lang['\\1'] : '\\1'", $error);
				}

				if (!$config['allow_avatar'] && $user_row['user_avatar_type'])
				{
					$error[] = $user->lang['USER_AVATAR_NOT_ALLOWED'];
				}
				else if ((($user_row['user_avatar_type'] == AVATAR_UPLOAD) && !$config['allow_avatar_upload']) ||
				 (($user_row['user_avatar_type'] == AVATAR_REMOTE) && !$config['allow_avatar_remote']) ||
				 (($user_row['user_avatar_type'] == AVATAR_GALLERY) && !$config['allow_avatar_local']))
				{
					$error[] = $user->lang['USER_AVATAR_TYPE_NOT_ALLOWED'];
				}

				// Generate users avatar
				$avatar_img = ($user_row['user_avatar']) ? get_user_avatar($user_row['user_avatar'], $user_row['user_avatar_type'], $user_row['user_avatar_width'], $user_row['user_avatar_height'], 'USER_AVATAR', true) : '<img src="' . $phpbb_admin_path . 'images/no_avatar.gif" alt="" />';

				$display_gallery = (isset($_POST['display_gallery'])) ? true : false;
				$avatar_select = basename(request_var('avatar_select', ''));
				$category = basename(request_var('category', ''));

				if ($config['allow_avatar_local'] && $display_gallery)
				{
					avatar_gallery($category, $avatar_select, 4);
				}

				$template->assign_vars(array(
					'S_AVATAR'			=> true,
					'S_CAN_UPLOAD'		=> $can_upload,
					'S_UPLOAD_FILE'		=> ($config['allow_avatar'] && $can_upload && $config['allow_avatar_upload']) ? true : false,
					'S_REMOTE_UPLOAD'	=> ($config['allow_avatar'] && $can_upload && $config['allow_avatar_remote_upload']) ? true : false,
					'S_ALLOW_REMOTE'	=> ($config['allow_avatar'] && $config['allow_avatar_remote']) ? true : false,
					'S_DISPLAY_GALLERY'	=> ($config['allow_avatar'] && $config['allow_avatar_local'] && !$display_gallery) ? true : false,
					'S_IN_GALLERY'		=> ($config['allow_avatar'] && $config['allow_avatar_local'] && $display_gallery) ? true : false,

					'AVATAR_IMAGE'			=> $avatar_img,
					'AVATAR_MAX_FILESIZE'	=> $config['avatar_filesize'],
					'USER_AVATAR_WIDTH'		=> $user_row['user_avatar_width'],
					'USER_AVATAR_HEIGHT'	=> $user_row['user_avatar_height'],

					'L_AVATAR_EXPLAIN'	=> sprintf($user->lang['AVATAR_EXPLAIN'], $config['avatar_max_width'], $config['avatar_max_height'], round($config['avatar_filesize'] / 1024)))
				);

			break;

		}

		// Assign general variables
		$template->assign_vars(array(
			'S_ERROR'			=> (sizeof($error)) ? true : false,
			'ERROR_MSG'			=> (sizeof($error)) ? implode('<br />', $error) : '')
		);
	}

	/**
	* Set option bit field for user options in a user row array.
	*
	* Optionset replacement for this module based on $user->optionset.
	*
	* @param array $user_row Row from the users table.
	* @param int $key Option key, as defined in $user->keyoptions property.
	* @param bool $value True to set the option, false to clear the option.
	* @param int $data Current bit field value, or false to use $user_row['user_options']
	* @return int|bool If $data is false, the bit field is modified and
	*                  written back to $user_row['user_options'], and
	*                  return value is true if the bit field changed and
	*                  false otherwise. If $data is not false, the new
	*                  bitfield value is returned.
	*/
	function optionset(&$user_row, $key, $value, $data = false)
	{
		global $user;

		$var = ($data !== false) ? $data : $user_row['user_options'];

		$new_var = phpbb_optionset($user->keyoptions[$key], $value, $var);

		if ($data === false)
		{
			if ($new_var != $var)
			{
				$user_row['user_options'] = $new_var;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return $new_var;
		}
	}

	/**
	* Get option bit field from user options in a user row array.
	*
	* Optionget replacement for this module based on $user->optionget.
	*
	* @param array $user_row Row from the users table.
	* @param int $key option key, as defined in $user->keyoptions property.
	* @param int $data bit field value to use, or false to use $user_row['user_options']
	* @return bool true if the option is set in the bit field, false otherwise
	*/
	function optionget(&$user_row, $key, $data = false)
	{
		global $user;

		$var = ($data !== false) ? $data : $user_row['user_options'];
		return phpbb_optionget($user->keyoptions[$key], $var);
	}
}

?>