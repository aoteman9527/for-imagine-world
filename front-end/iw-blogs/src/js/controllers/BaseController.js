/**
 * Created by tuanlhd on 11/17/14.
 */
function BaseController () {
    PARAM_REDIRECT = "redirect"
    this.view = null;//this is abstract variable. it will be replace by Child
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

    /**
     * @RequestParam int forumId,
     @RequestParam int page,
     @RequestParam int num,
     @RequestParam String sortType,
     @RequestParam byte topicApproved
     * @param forumId
     * @param callback
     */
    this.loadForum=function(forumId,page,num,sortType,topicApproved,callback){
        var self =this;
        jQuery.post( IW_HOST_CONTEXT_GET_TOPICS,
            {
                forumId:forumId,
                page:page,
                num:num,
                sortType:sortType,
                topicApproved:topicApproved
            }
            , function(data){
                self.view.draw(new TopicList(data));
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

    /**
     * this function support for Decorator pattern.
     * Cause we need to control many views
     * After new constructor this function will be call immediately
     * for setting up views.
     */
    this.setUpViews = function(){
        throw new Error("This function is not support");
    }
};