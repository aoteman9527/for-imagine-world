Function.prototype.inheritsFrom = function( parentClassOrObject ){
    if ( parentClassOrObject.constructor == Function )
    {
        //Normal Inheritance
        this.prototype = new parentClassOrObject;
        this.prototype.constructor = this;
        this.prototype.parent = parentClassOrObject.prototype;
    }
    else
    {
        //Pure Virtual Inheritance
        this.prototype = parentClassOrObject;
        this.prototype.constructor = this;
        this.prototype.parent = parentClassOrObject;
    }
    return this;
}

var include = function(insideElement,url){
    jQuery.get(url,function(data){
        jQuery(insideElement).replaceWith(data);

    });
}
function BController () {
    PARAM_REDIRECT = "redirect"

    this.urlParam=function(name){
        var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
        return results !=null ? (results[1] || 0):0;
    }

    this.onLoad=function(){
        var pageDirect = this.urlParam(PARAM_REDIRECT);
        switch (pageDirect){
            case EnumRedirectPage.HOME_PAGE:

                break;
            case EnumRedirectPage.FORUM_PAGE:

                break;
            case EnumRedirectPage.TOPIC_PAGE:

                break;
            default :
                jQuery("body").html(this.getViewHtml());
                break;
        }
    }

    this.loadForum=function(forumId,callback){
        jQuery.post( "ajax/test.html", function( data ) {
            $( ".result" ).html( data );
        });
    }

    this.loadTopic = function(topicId,callback){

    }

    this.changeController = function(newController){
        controller = newController;
    }

    /**
     * You must implement this function. cause it is getting view of each Page.
     */
    this.getViewHtml = function(){
        throw new Error("this function is not support");
    }


};

HomeController.inheritsFrom(BController);
function HomeController () {
    this.getViewHtml = function(){
        return "<img id=\"indexHome\" onload=\"include(this,this.id+'.html')\" src=\"img/apple-touch-icon-144-precomposed.png\" >";
    }
}


var controller = new HomeController();

