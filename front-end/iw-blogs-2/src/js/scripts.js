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

/**
 * After are URLs configuration
 * **/
var IW_HOST="http://localhost:8080";
var IW_HOST_CONTEXT=IW_HOST+"/iw-web"
var IW_HOST_CONTEXT_GET_TOPICS= IW_HOST_CONTEXT+"/getTopics";
var IW_HOST_CONTEXT_AUTHORIZE= IW_HOST_CONTEXT+"/authorize";
var IW_HOST_CONTEXT_USER_INFO= IW_HOST_CONTEXT+"/userInfo";

/**
 * After are pages used for globalApp.allowDisplayItems
 */
var PAGE_HOME = ["partHeader","partFooter","partForumMenu","partIntroduction"]
var PAGE_FORUM_DETAIL = ["partHeader","partFooter","partForumMenu","partForumDetail"]
var PAGE_TOPIC_DETAIL = ["partHeader","partFooter","partForumMenu","partTopicDetail"]

/**
 * the globalApp store all global variable
 * @type {{userInfo: null, allowDisplayItems: string[]}}
 */
var globalApp = {
    userInfo:null,
    allowDisplayItems:PAGE_FORUM_DETAIL//this will be update by controller.
}