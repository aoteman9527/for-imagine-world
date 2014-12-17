(function($) {
    "use strict"; 
    $(function() {	
		// remove width + height attributes from uploaded images
		$('article img, .wp-post-image').each(function(){ 
	        $(this).removeAttr('width')
	        $(this).removeAttr('height');
	    });
	    // layout teasers using masonry	
	    $('#teasers').imagesLoaded( function() {
			$('#teasers').masonry({
				gutter: 20,
				isResizable: true,
				itemSelector: '.teaser'
			});
			$('#teasers').masonry('bindResize');
		}); 	    
		
		// teaser thumb hover effect
		$('.thumb img').hover(
			function() {
		    	$(this).fadeTo('fast', 0.3);
			}, function() {
				$(this).fadeTo('fast', 1);
		  	}
		);
		// remove trailing slash from tag list
	    $('.tags').each(function() {
			$('.slash:last', this).remove();
		});		
 	}); 
}(jQuery));