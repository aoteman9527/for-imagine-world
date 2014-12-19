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
define('AUTH_KEY',         ')qwMZa0+0uoo)SF2%N7igF@T8]3$N0g~_j#-B91-?V-W2s|x.5`Z4lj9bLr6o^01');
define('SECURE_AUTH_KEY',  'bq%i2DzhHu!dTA *(nvCK O;|-WP|;@CMg-A^dE_2>-:wFs/Y>aHJoV]/]B66B-z');
define('LOGGED_IN_KEY',    'XOH#tIn__%JbL>jpd)?S/5h7go->UeMm+X^R~do@--Ti-LFN$43D+]vPQ2J(,2]F');
define('NONCE_KEY',        'UD#o$s@aP{]l(5b3ly=|%3i^4BR{{cvyg?Yy&%~0D=qT04nb*bCsF#`*?{L6=#~+');
define('AUTH_SALT',        '7-|}e.9V>C*yrh_otuh!K :EL(@rFNM^s*/djC(D{zVbYl|-cv.vTm4)Nc]DTNq_');
define('SECURE_AUTH_SALT', ': 1d-EG!e>y6ke%Yom;OYyV|}oYa[+h/1)KX=(TClekq&~h[,+_m0&Yx}@7?Ec_u');
define('LOGGED_IN_SALT',   '5Ja=^$+&RHpO7m%LiCT.(An6.<L^+!m3+daTSP~8i0z$.;AED-%*e<1w;-sc*_#%');
define('NONCE_SALT',       '@N+KUog0rpPxYZKlXY6r+_4,3jlOu.+^|;?zQpafB4I-kN~<<-JJuCb:3o2qk-Y$');

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
