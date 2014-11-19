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

if (!String.prototype.format) {
    String.prototype.format = function() {
        var newStr = this, i = 0;
        while (/%s/.test(newStr))
            newStr = newStr.replace("%s", arguments[i++])

        return newStr;
    }
}
var globalApp = {}
/**
 * After are URLs configuration
 * **/
var IW_HOST="http://localhost:8080";
var IW_HOST_CONTEXT=IW_HOST+"/iw-web"
var IW_HOST_CONTEXT_GET_TOPICS= IW_HOST_CONTEXT+"/getTopics";
var IW_HOST_CONTEXT_AUTHORIZE= IW_HOST_CONTEXT+"/authorize";
var IW_HOST_CONTEXT_USER_INFO= IW_HOST_CONTEXT+"/userInfo";

