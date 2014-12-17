<div class="sidebar three columns omega">
	<?php if (is_single()) { ?>
	<nav id="post-nav">
		<?php previous_post_link('%link', '<span>&lsaquo;</span> PREV', FALSE); ?>  <?php next_post_link('%link', '&infin; NEXT <span>&rsaquo;</span>', FALSE); ?>  		
	</nav>
	<?php } ?>
	<?php dynamic_sidebar('right-sidebar'); ?>
</div>