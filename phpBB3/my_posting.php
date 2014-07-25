<?php
define('IN_PHPBB', true);
$phpbb_root_path = (defined('PHPBB_ROOT_PATH')) ? PHPBB_ROOT_PATH : './';
$phpEx = substr(strrchr(__FILE__, '.'), 1);
include($phpbb_root_path . 'common.' . $phpEx);
include($phpbb_root_path . 'includes/functions_posting.' . $phpEx);
include($phpbb_root_path . 'includes/message_parser.' . $phpEx);

//Pre-condition - must logged in



// Start session management
$user->session_begin();
$auth->acl($user->data);

$message_parser = new parse_message();

$post_data['post_subject']		= utf8_normalize_nfc(request_var('subject', '', true));

$post_data['topic_type']		= request_var('topic_type', (($mode != 'post') ? (int) $post_data['topic_type'] : POST_NORMAL));
$post_data['topic_time_limit']	= request_var('topic_time_limit', (($mode != 'post') ? (int) $post_data['topic_time_limit'] : 0));

$message_parser->message		= utf8_normalize_nfc(request_var('message', '', true));
$message_md5 = md5($message_parser->message);

$post_data['post_edit_reason']	= (!empty($_POST['edit_reason']) && $mode == 'edit' && $auth->acl_get('m_edit', $forum_id)) ? utf8_normalize_nfc(request_var('edit_reason', '', true)) : '';
$post_data['icon_id']			= (!isset($post_data['icon_id']) || in_array($mode, array('quote', 'reply'))) ? 0 : (int) $post_data['icon_id'];
$post_data['icon_id']           = request_var('icon', (int) $post_data['icon_id']);


$post_id	= request_var('p', 0);
$topic_id	= request_var('t', 0);
$forum_id	= request_var('f', 0);
$draft_id	= request_var('d', 0);
$lastclick	= request_var('lastclick', 0);

// HTML, BBCode, Smilies, Images and Flash status
$bbcode_status	= ($config['allow_bbcode'] && $auth->acl_get('f_bbcode', $forum_id)) ? true : false;
$smilies_status	= ($config['allow_smilies'] && $auth->acl_get('f_smilies', $forum_id)) ? true : false;
$img_status		= ($bbcode_status && $auth->acl_get('f_img', $forum_id)) ? true : false;
$url_status		= ($config['allow_post_links']) ? true : false;
$flash_status	= ($bbcode_status && $auth->acl_get('f_flash', $forum_id) && $config['allow_post_flash']) ? true : false;
$quote_status	= true;

$post_data['poll_options']		= array();
$post_data['enable_bbcode']		= (!$bbcode_status || isset($_POST['disable_bbcode'])) ? false : true;
$post_data['enable_smilies']	= (!$smilies_status || isset($_POST['disable_smilies'])) ? false : true;
$post_data['enable_urls']		= (isset($_POST['disable_magic_url'])) ? 0 : 1;
$post_data['enable_sig']		= (!$config['allow_sig'] || !$auth->acl_get('f_sigs', $forum_id) || !$auth->acl_get('u_sig')) ? false : ((isset($_POST['attach_sig']) && $user->data['is_registered']) ? true : false);

$data = array(
    'topic_title'			=> (empty($post_data['topic_title'])) ? $post_data['post_subject'] : $post_data['topic_title'],
    'topic_first_post_id'	=> 0,
    'topic_last_post_id'	=> 0,
    'topic_time_limit'		=> $post_data['topic_time_limit'],
    'topic_attachment'		=> (isset($post_data['topic_attachment'])) ? (int) $post_data['topic_attachment'] : 0,
    'post_id'				=> $post_id,
    'topic_id'				=> $topic_id,
    'forum_id'				=> $forum_id,
    'icon_id'				=> $post_data['icon_id'],
    'poster_id'				=> $user->data['user_id'],// id of poster , root = 2
    'enable_sig'			=> (bool) $post_data['enable_sig'],
    'enable_bbcode'			=> (bool) $post_data['enable_bbcode'],
    'enable_smilies'		=> (bool) $post_data['enable_smilies'],
    'enable_urls'			=> (bool) $post_data['enable_urls'],
    'enable_indexing'		=> (bool) $post_data['enable_indexing'],
    'message_md5'			=> (string) $message_md5,
    'post_time'				=> 0,
    'post_checksum'			=> '',
    'post_edit_reason'		=> "THis is post reason",
    'post_edit_user'		=> 0,
    'forum_parents'			=> "a:1:{i:1;a:2:{i:0;s:19:\"Your first category\";i:1;i:0;}}",// search in DB
    'forum_name'			=> "Your first forum",
    'notify'				=> false,
    'notify_set'			=> 0,
    'poster_ip'				=> "127.0.0.1",
    'post_edit_locked'		=> 0,
    'bbcode_bitfield'		=> $message_parser->bbcode_bitfield,
    'bbcode_uid'			=> $message_parser->bbcode_uid,
    'message'				=> $message_parser->message,
    'attachment_data'		=> $message_parser->attachment_data,
    'filename_data'			=> $message_parser->filename_data,

    'topic_approved'		=> false,
    'post_approved'			=> false,
);
$post_author_name = ((!$user->data['is_registered'] || $mode == 'edit') && $post_data['username'] !== '') ? $post_data['username'] : '';
$mode="post";
$poll=[];
$post_author_name=$user->data['username'];
$redirect_url = submit_post($mode, $post_data['post_subject'], $post_author_name, $post_data['topic_type'], $poll, $data, $update_message, ($update_message || $update_subject) ? true : false);

echo $redirect_url;
?>