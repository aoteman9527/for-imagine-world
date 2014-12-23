<?php

// define content area width
if (!isset($content_width)) $content_width = 520;

// sets up theme defaults and registers the WordPress features that Alpha Next uses
function alphatrinity_setup() {	
	register_nav_menu('primary-menu', __('Primary Menu', 'alphatrinity'));
	add_theme_support('post-thumbnails');
	add_image_size('teaser', 320, 9999); 	
	add_theme_support('automatic-feed-links');	
}
add_action('after_setup_theme', 'alphatrinity_setup');

// format page titles
function alphatrinity_wp_title($title, $sep) {
	global $paged, $page;
	if (is_feed())
		return $title;	
	$title .= get_bloginfo('name');	
	$site_description = get_bloginfo('description','display');
	if ($site_description && (is_home() || is_front_page()))
		$title = "$title $sep $site_description";	
	if ($paged >= 2 || $page >= 2)
		$title = "$title $sep " . sprintf( __('Page %s', 'alphatrinity'), max($paged, $page));
	return $title;
}
add_filter( 'wp_title', 'alphatrinity_wp_title', 10, 2);

// load styles
function alphatrinity_styles() {
	wp_enqueue_style('alphatrinity_style', get_stylesheet_uri());    
}
add_action('wp_enqueue_scripts', 'alphatrinity_styles');

// load javascript
function alphatrinity_scripts() {
	if(!is_admin()){
		wp_enqueue_script('jquery');
		wp_enqueue_script('alphatrinity_scripts', get_template_directory_uri() . '/assets/scripts.js'); 
		wp_enqueue_script('alphatrinity_masonry', get_template_directory_uri() . '/assets/masonry.pkgd.min.js');
		wp_enqueue_script('alphatrinity_imgLoaded', get_template_directory_uri() . '/assets/imagesloaded.pkgd.min.js');
	}
	if (is_singular()) wp_enqueue_script('comment-reply');
}
add_action('wp_enqueue_scripts', 'alphatrinity_scripts');

// register widgets
function alphatrinity_widgets_init() {
	register_sidebar(array(
		'name' => __('Left Sidebar', 'alphatrinity'),
		'id' => 'left-sidebar',
		'description' => __('Widgets in this area will appear in the left hand sidebar on all pages and posts.', 'alphatrinity'),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget' => "</aside>",
		'before_title' => '<h3 class="widget-title">',
		'after_title' => '</h3>'
	));
	register_sidebar(array(
		'name' => __('Right Sidebar', 'alphatrinity'),
		'id' => 'right-sidebar',
		'description' => __('Widgets in this area will appear in the right hand sidebar on posts and pages.', 'alphatrinity'),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget' => "</aside>",
		'before_title' => '<h3 class="widget-title">',
		'after_title' => '</h3>'
	));
}
add_action('widgets_init', 'alphatrinity_widgets_init');

// add read more link to excerpts
function alphatrinity_excerpt_more($more) {
       global $post;
	return '...</p><p><a class="more" href="'. get_permalink($post->ID) . '"> Read more &rarr;</a></p>';
}
add_filter('excerpt_more', 'alphatrinity_excerpt_more');

// display page numbers in teaser pager
if (!function_exists('alphatrinity_pagination')):
	function alphatrinity_pagination() {
		global $wp_query;
		$big = 999999999;		
		echo paginate_links( array(
			'base' => str_replace($big, '%#%', esc_url(get_pagenum_link($big))),
			'format' => '?paged=%#%',
			'current' => max(1, get_query_var('paged')),
			'total' => $wp_query->max_num_pages
		));
	}
endif;

// custom link rollover color
function alphatrinity_register_theme_customizer($wp_customize) { 
    $wp_customize->add_setting(
        'alphatrinity_link_color',
        array(
	        'default' => '#ff3300',
            'transport' => 'postMessage'
        )
    ); 
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'link_color',
            array(
                'label' => __('Link Rollover Color', 'alphatrinity'),
                'section' => 'colors',
                'settings' => 'alphatrinity_link_color'
            )
        )
    ); 
}
add_action('customize_register', 'alphatrinity_register_theme_customizer');

// apply user defined link rollover color
function alphatrinity_customizer_css() {
    ?>
    <style type="text/css">
        a:hover {color: <?php echo get_theme_mod('alphatrinity_link_color'); ?>;}
        .thumb {background-color:<?php echo get_theme_mod('alphatrinity_link_color'); ?>}        
    </style>
    <?php
}
add_action('wp_head', 'alphatrinity_customizer_css');

// live preview of rollover color
function alphatrinity_customizer_live_preview() { 
    wp_enqueue_script(
        'alphatrinity-theme-customizer',
        get_template_directory_uri() . '/assets/customizer.js', array('jquery', 'customize-preview'), true); 
}
add_action('customize_preview_init', 'alphatrinity_customizer_live_preview');

?>