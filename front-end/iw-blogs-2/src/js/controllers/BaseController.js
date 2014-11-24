/**
 * Created by tuanlhd on 11/17/14.
 */
function BaseController ($scope,$http) {

    /**
     * this setting for sub-calss call
     */
    if($scope){
        $scope.c=this;
        $scope.EnumSortType=EnumSortType;
    }

    PARAM_REDIRECT = "redirect"
    this.view = null;//this is abstract variable. it will be replace by Child
    this.urlParam=function(name){
        var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
        return results !=null ? (results[1] || 0):0;
    }



    this.loadTopic = function(topicId,callback){

    }

    /**
     * this was used in html page
     * @returns {null}
     */
    this.getUserInfo=function(){
        return globalApp.userInfo;
    }

    /**
     * this was used in html page to allowed display
     * @param idPart
     * @returns {boolean}
     */
    this.isDisplay=function(idPart){
        return globalApp.allowDisplayItems.indexOf(idPart)>-1?true:false;
    }

    /**
     *
     * @param page: refer to script.js/PAGE_HOME
     */
    this.setPage=function(page,model){
        globalApp.allowDisplayItems=angular.copy(page);
        globalApp.allowDisplayItems.model=model;
    }

    this.getModel=function(){
        return globalApp.allowDisplayItems.model;
    }
};