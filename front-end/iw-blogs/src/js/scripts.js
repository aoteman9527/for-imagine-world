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

/**
 * After are URLs configuration
 * **/
var IW_HOST="localhost:8080";
var IW_HOST_CONTEXT=IW_HOST+"/iw-web"
var IW_HOST_CONTEXT_GET_TOPICS= IW_HOST_CONTEXT+"/getTopics";

