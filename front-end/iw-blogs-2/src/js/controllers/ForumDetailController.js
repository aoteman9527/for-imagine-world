/**
 * Created by tuanlhd on 11/20/14.
 */
ForumDetailController.inheritsFrom(BaseController);
function ForumDetailController($scope,$http){
    BaseController.call(this,$scope,$http);

    this.isNotExistedTopic=function(){
        if(this.getModel())
        return this.getModel().topics.length==0;
    }

    this.getTopics=function(){
        if(this.getModel())
        return this.getModel().topics;
    }

    this.shoudDisplayPagination=function(){
        return true; //cause the api does not return total records
        if(this.getModel())
        return this.getModel().topics.length>this.getModel().page;
    }

}