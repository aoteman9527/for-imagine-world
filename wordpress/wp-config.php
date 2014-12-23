<?php
/**
 * The base configurations of the WordPress.
 *
 * This file has the following configurations: MySQL settings, Table Prefix,
 * Secret Keys, and ABSPATH. You can find more information by visiting
 * {@link http://codex.wordpress.org/Editing_wp-config.php Editing wp-config.php}
 * Codex page. You can get the MySQL settings from your web host.
 *
 * This file is used by the wp-config.php creation script during the
 * installation. You don't have to use the web site, you can just copy this file
 * to "wp-config.php" and fill in the values.
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'wordpress');

/** MySQL database username */
define('DB_USER', 'letuan');

/** MySQL database password */
define('DB_PASSWORD', '123456');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         '+l,ySHFSM|E?S=aHTU0wT_OI~btt>+6!esUA)EBO)d%&gp7)Or-7h|1j]-m02OG4');
define('SECURE_AUTH_KEY',  '-p#SQQJIAiGoxD),f+X&*>Pv&I9b->AN_J68v#eSU~OD}I41hOo!lt(U{%L6*NIY');
define('LOGGED_IN_KEY',    'keeUR8HE*i7@-[+YlG-~;d(vvN+nmu-(d[~kiK,Rx}$[N#-2[|B|nG>xF/@:`$FY');
define('NONCE_KEY',        'tG}o@%}lPrCQ/9h|{%vu5Q[3:*!z~qDHIRHKh/.0IoVbQ|XEqS*pAyhk42qpk[/]');
define('AUTH_SALT',        '[]S(!`|sH_,D<6TuBO|r bUq&qxGG)xzQBGBTCCNcMAA#J~X<jOdV%%b1QiTz>; ');
define('SECURE_AUTH_SALT', '-+T1Bwp>cgE|w(xt9H&BWt8+!TJf(jF{2F|*sT_jgRO-@H+d|-?~9caI[exxMjkT');
define('LOGGED_IN_SALT',   '6la-|)h!E^[1e6A}/qH?Q_D iC;aqs-9K-=]Is|Rs}tS)]-28`vi|p_n;%x6~W*4');
define('NONCE_SALT',       'yjNRs}UgA7{N|S4uQY+|*XW-^6tLKkyg?WQ_9u,]KX~Z5l})?P dRPIs+|B]!N4d');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each a unique
 * prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
