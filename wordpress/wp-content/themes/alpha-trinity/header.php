<!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<!--TUAN CUSTOM META-->
    <link rel="author" href="https://plus.google.com/+LeeTu%E1%BA%A5nl%C3%A9/about">
    <meta name="description" content="<?php $post = get_post(get_the_ID()); echo strip_tags(substr($post->post_title,0 , 500)); ?>">
    <!--TUAN CUSTOM META-->

    <meta charset="<?php bloginfo('charset'); ?>" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><?php bloginfo(‘name’); ?><?php wp_title(); ?></title>

    <meta http-equiv=”Content-Type” content=”<?php bloginfo(‘html_type’); ?>; charset=<?php bloginfo(‘charset’); ?>” />

    <link rel="profile" href="http://gmpg.org/xfn/11" />
    <link rel="pingback" href="<?php bloginfo('pingback_url'); ?>" />
    <!--[if lt IE 9]>
    <script src="<?php echo get_template_directory_uri(); ?>/assets/html5shiv.js" type="text/javascript"></script>
    <![endif]-->
    <?php wp_head(); ?>

    <!--GOOGLE ANALYTICs-->
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-57161245-3', 'auto');
        ga('send', 'pageview');

    </script>

</head>
<body <?php body_class(); ?>>
	<div class="container">
