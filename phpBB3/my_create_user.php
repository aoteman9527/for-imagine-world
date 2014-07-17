<?php 
define('IN_PHPBB', true);
$phpbb_root_path = (defined('PHPBB_ROOT_PATH')) ? PHPBB_ROOT_PATH : './';
$phpEx = substr(strrchr(__FILE__, '.'), 1);

include($phpbb_root_path . 'common.' . $phpEx);
include($phpbb_root_path . 'includes/functions_user.' . $phpEx);

// Start session management
$user->session_begin();
$auth->acl($user->data);
$user->setup('viewforum');




// username of the user being added
$username = 'playernodie2';

// the user’s password, which is hashed before inserting into the database
$password = '123456';

// an email address for the user
$email_address = 'my_email@domain_name.tld';

// default is 2 for registered users, or 5 for coppa users.
$group_id = 2;	

// timezone of the user... Based on GMT in the format of '-6', '-4', 3, 9 etc...
$timezone = '-6';

// two digit default language for this use of a language pack that is installed on the board.
$language = 'en';

// user type, this is USER_INACTIVE, or USER_NORMAL depending on if the user needs to activate himself, or does not.
// on registration, if the user must click the activation link in their email to activate their account, their account
// is set to USER_INACTIVE until they are activated. If they are activated instantly, they would be USER_NORMAL
//Defines what type the user is. 0 is normal user, 1 is inactive and needs to activate their account through an activation link sent in an email, 2 is a pre-defined type to ignore user (i.e. bot), 3 is Founder.
$user_type = 0;

// here if the user is inactive and needs to activate thier account through an activation link sent in an email
// we need to set the activation key for the user... (the goal is to get it about 10 chars of randomization)
// you can use any randomization method you want, for this example, I’ll use the following...
$user_actkey = md5(rand(0, 100) . time());
$user_actkey = substr($user_actkey, 0, rand(8, 12));

// IP address of the user stored in the Database.
$user_ip = $user->ip;

// registration time of the user, timestamp format.
$registration_time = time();

// inactive reason is the string given in the inactive users list in the ACP.
// there are four options: INACTIVE_REGISTER, INACTIVE_PROFILE, INACTIVE_MANUAL and INACTIVE_REMIND
// you do not need this if the user is not going to be inactive
// more can be read on this in the inactive users section
//$user_inactive_reason = INACTIVE_REGISTER;

// time since the user is inactive. timestamp.
$user_inactive_time = time();

// these are just examples and some sample (common) data when creating a new user.
// you can include any information 
$user_row = array(
    'username'              => $username,
    'user_password'         => phpbb_hash($password),
    'user_email'            => $email_address,
    'group_id'              => (int) $group_id,
    'user_timezone'         => (float) $timezone,
    'user_dst'              => $is_dst,
    'user_lang'             => $language,
    'user_type'             => $user_type,
    'user_actkey'           => $user_actkey,
    'user_ip'               => $user_ip,
    'user_regdate'          => $registration_time,
//    'user_inactive_reason'  => $user_inactive_reason,
    'user_inactive_time'    => $user_inactive_time,
);

// Custom Profile fields, this will be covered in another article.
// for now this is just a stub
// all the information has been compiled, add the user
// the user_add() function will automatically add the user to the correct groups
// and adding the appropriate database entries for this user...
// tables affected: users table, profile_fields_data table, groups table, and config table.
$user_id = user_add($user_row);
print $user_id."\r\n";
print_r ($user_row);
?>
