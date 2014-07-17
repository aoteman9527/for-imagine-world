<?php

define('IN_PHPBB', true);

$phpbb_root_path = (defined('PHPBB_ROOT_PATH')) ? PHPBB_ROOT_PATH : './';
$phpEx = substr(strrchr(__FILE__, '.'), 1);

include($phpbb_root_path . 'common.' . $phpEx);
include($phpbb_root_path . 'includes/functions_user.' . $phpEx);


$username = "playernodien";
$file_uploads	= (@ini_get('file_uploads') == '1' || strtolower(@ini_get('file_uploads')) === 'on') ? true : false;
$submit		= (isset($_POST['update']) && !isset($_POST['cancel'])) ? true : false;

$sql = 'SELECT user_id
				FROM ' . USERS_TABLE . "
				WHERE username_clean = '" . $db->sql_escape(utf8_clean_string($username)) . "'";
$result = $db->sql_query_limit($sql, 1);
$user_row = $db->sql_fetchrow($result);
$can_upload = (file_exists($phpbb_root_path . $config['avatar_path']) && phpbb_is_writable($phpbb_root_path . $config['avatar_path']) && $file_uploads) ? true : false;


    if ($submit)
    {

//        if (!check_form_key($form_name))
//        {
//            trigger_error($user->lang['FORM_INVALID'] . adm_back_link($this->u_action . '&amp;u=' . $user_id), E_USER_WARNING);
//        }

//        if (avatar_process_user($error, $user_row, $can_upload))
//        {
//            trigger_error($user->lang['USER_AVATAR_UPDATED'] . adm_back_link($this->u_action . '&amp;u=' . $user_row['user_id']));
//        }
        $upload_result = avatar_process_user($error, $user_row, $can_upload);
        if($upload_result){
            echo "upload success";
        } else {
            echo "FAIL";
        }
    }
?>