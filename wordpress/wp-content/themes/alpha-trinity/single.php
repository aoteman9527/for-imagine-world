<?php get_header(); ?>
<?php get_sidebar(); ?>
<?php while (have_posts()) : the_post(); ?>	
	<article class="nine columns">
		<div id="post-<?php the_ID(); ?>" <?php post_class(); ?>>					 
			<?php the_post_thumbnail('large'); ?>
			<h1 id="main-heading"><?php the_title(); ?></h1>
			<p id="meta"><?php the_date(); ?> - <?php the_category(' / '); ?></p>				  	
			<?php the_content(); ?>
			<?php
				$tags = get_the_tags();
				if ($tags) {
					echo '<p class="tags">&rsaquo; tags: ';
				    foreach($tags as $tag) {
				    	echo '<a href="' . get_tag_link( $tag->term_id ) . '">' . $tag->name.'</a> <span class="slash">/</span> '; 
				  	}
				  	echo '</p>';
				}
			?>		
			<?php comments_template(); ?>	
			<?php wp_link_pages('before=<div id="page-links">&after=</div>'); ?>						
		</div>		
	</article>
<?php endwhile; ?>	
<?php get_sidebar('right'); ?>
<?php get_footer(); ?>	