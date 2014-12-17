<?php
	if (post_password_required())
		return;	
	if (have_comments()) : ?>
	    <h3 id="comments">Comments</h3>       
	    <ol class="comment-list">
	    	<?php wp_list_comments(); ?>
	    	<?php paginate_comments_links(); ?>
	    </ol>        
<?php				 
	endif;
	comment_form();
?>