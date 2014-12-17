<?php get_header(); ?>
<?php get_sidebar(); ?>	
<?php if (is_search()){ ?>
	<h1 id="main-heading">Search Results</h1>
<?php } ?>
<div id="teasers" class="twelve columns omega">	
	<?php if ( have_posts() ) : while ( have_posts() ) : the_post(); ?>
		<div class="teaser">
			<div id="post-<?php the_ID(); ?>" <?php post_class(); ?>>	
				<?php if (has_post_thumbnail()) { ?>						
					<div class="thumb"><a href="<?php echo get_permalink(); ?>"><?php the_post_thumbnail('teaser'); ?></a></div>														
				<?php } ?>	
				<?php if (is_sticky()) { ?>
					<div class="sticky-text">Featured</div>
				<?php } ?> 
				<?php $title = get_the_title();
					if (strlen($title) == 0) { ?>
						<p class="teaser-meta"><a href="<?php echo get_permalink(); ?>"><?php echo get_the_date(); ?> / <?php comments_number('0 comments', '1 comment', '% comments'); ?></a></p>
					<?php } else { ?>
						<h3><a href="<?php echo get_permalink(); ?>"><?php the_title(); ?></a></h3>				
						<p class="teaser-meta"><?php echo get_the_date(); ?> / <?php comments_number('0 comments', '1 comment', '% comments'); ?></p>
				<?php } ?>				
				<div class="teaser-excerpt"><?php the_excerpt(); ?></div>
			</div>
		</div>
	<?php endwhile; else: ?>
	<p>Sorry, no posts matched your criteria.</p>
	<?php endif; ?>	
</div>
<div id="pagination" class="twelve columns"><?php alphatrinity_pagination(); ?></div>
<?php get_footer(); ?>		