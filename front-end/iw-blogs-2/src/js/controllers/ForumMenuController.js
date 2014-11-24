/**
 * Created by tuanlhd on 11/24/14.
 */
ForumMenuController.inheritsFrom(BaseController)
function ForumMenuController($scope,$http){
    BaseController.call(this,$scope,$http);
    /**
     * @RequestParam int forumId,
     @RequestParam int page,
     @RequestParam int num,
     @RequestParam String sortType,
     @RequestParam byte topicApproved
     * @param forumId
     */
    this.loadForum=function(forumId,page,num,sortType,topicApproved){

        var self = this;
        $http.post(IW_HOST_CONTEXT_GET_TOPICS,
            "forumId=%s&page=%s&num=%s&sortType=%s&topicApproved=%s"
                .format(forumId,page,num,sortType,topicApproved)
            ,
            {
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }
        ).success(function(data){
            self.setPage(PAGE_FORUM_DETAIL,data);
            }).error(function(data){
                $scope.alertLoginFail="Please try login again !!!"
            });
    }
}