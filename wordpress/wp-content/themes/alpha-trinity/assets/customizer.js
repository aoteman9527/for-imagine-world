(function($) {
    "use strict"; 
    wp.customize('alphatrinity_link_color', function(value) {
        value.bind(function(to) {
            $('a').hover(
				function() {
			    	$(this).css('color', to);
			  	}, function() {
			    	$(this).css('color', '#333');
			  	}
			);		
			$('.thumb').hover(
				function() {
			    	$(this).css('background-color', to);
			  	}, function() {
			    	$(this).css('background-color', '#333');
			  	}
			);					
        });
    }); 
})(jQuery);