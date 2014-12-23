<div class="sidebar four columns">
	<p id="blog-name"><a href="<?php echo esc_url( home_url( '/' ) ); ?>"><?php bloginfo('name'); ?></a></p>
	<p id="blog-description"><?php bloginfo('description'); ?></p>	
	<?php if (has_nav_menu('primary-menu')){ ?>
		<nav id="sidebar-menu">
			<?php wp_nav_menu(array('theme_location' => 'primary-menu')); ?>
		</nav>
	<?php } ?>	
	<?php get_search_form(); ?>
	<?php dynamic_sidebar('left-sidebar'); ?>
	<p id="copyright">&copy; <?php echo date('Y'); ?> <?php bloginfo('name'); ?></p>
	<p id="powered-by">Powered by <a href="http://wordpress.org" title="Semantic Personal Publishing Platform" target="_blank">WordPress</a> and <a href="http://www.alphawpthemes.com/themes/trinity" target="_blank">Alpha Trinity</a></p>		  		
</div>