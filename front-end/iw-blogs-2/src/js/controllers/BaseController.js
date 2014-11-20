/**
 * Created by tuanlhd on 11/17/14.
 */
function BaseController ($scope) {
    if($scope)$scope.c=this;
    PARAM_REDIRECT = "redirect"
    this.view = null;//this is abstract variable. it will be replace by Child
    this.urlParam=function(name){
        var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
        return results !=null ? (results[1] || 0):0;
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

    this.getUserInfo=function(){
        return globalApp.userInfo;
    }

    this.isDisplay=function(idPart){
        return globalApp.allowDisplayItems.indexOf(idPart)>-1?true:false;
    }
};