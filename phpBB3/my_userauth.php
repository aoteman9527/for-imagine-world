<?php

define('IN_PHPBB', true);
$phpbb_root_path = (defined('PHPBB_ROOT_PATH')) ? PHPBB_ROOT_PATH : './';
$phpEx = substr(strrchr(__FILE__, '.'), 1);
require($phpbb_root_path . 'common.' . $phpEx);

$username = $_POST['username'];
$password = $_POST['password'];
$remember = $_POST['autologin'];

$user->session_begin();
$auth->acl($user->data);
$user->setup();

if($username){
    $auth->login($username, $password, $remember, 1, 0);
    // Respond to a login failure
    if ($user->data['user_id'] == ANONYMOUS)
    {
        echo "LOGIN FAIL";
    }

// Respond to a successful login
    else
    {
        // This would send the user to the phpBB forum, already logged in.
        // redirect(append_sid("{$phpbb_root_path}index.$phpEx"));

        // We timeout the authentication elsewhere so set the cookie
        // the expiration time is set to a month
        $expire = time() + 60*60*24*30;

        // Put the user ID into an ASP-readable cookie and put a safely-hashed
        // key into another cookie that ASP can reproduce on the other side
        // for verification purposes.
        $key = md5($user->data['user_email_hash'] . $user->data['user_password']);

        setcookie("phpbb_authUID", $user->data['user_id'], $expire);
        setcookie("phpbb_auth_username", $user->data['username'], $expire);
        setcookie("phpbb_authkey", $key, $expire);

//    header('Location: ' . $navtarget);
        echo "LOGIN SUCCESS ".$_COOKIE['phpbb_authUID']."</br>";
        echo $user->data['username']."</br>";
        echo $expire."</br>";
        print_r ($_COOKIE);
    }
}
else {

    $expire = time()-3600;
    echo "COOKIE current user ".$_COOKIE['phpbb_authUID']."</br>";
    echo "COOKIE current user ".$_COOKIE['phpbb_auth_username']."</br>";
    setcookie("phpbb_authUID", $user->data['user_id'], $expire);
    setcookie("phpbb_auth_username", $user->data['username'], $expire);
    setcookie("phpbb_authkey", $key, $expire);
    $user->session_kill(true);
}
?>