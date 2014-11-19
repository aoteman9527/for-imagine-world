/**
 * Created by tuanlhd on 11/19/14.
 */
HeaderController.inheritsFrom(BaseController);
function HeaderController($scope,$http){
    $scope.email=""
    $scope.password=""
    $scope.c=this

    this.login = function(){
        var self =this;
        var handler = function(data){
            if(data instanceof Object )
                data = data.responseJSON;
            else
                data = JSON.parse(data);
            data.originalRequest = IW_HOST_CONTEXT_AUTHORIZE
            self.view.draw(data);
        }
//        jQuery.post( IW_HOST_CONTEXT_AUTHORIZE,
//            {
//                email:email,
//                password:password
//            }
//            , handler)
//            .error(handler);

        $http.post(IW_HOST_CONTEXT_AUTHORIZE,
            {
            email:$scope.email,
            password:$scope.password
            }
        ).success(handler).error(handler);
    }

    this.validateEmail = function(){
        console.log($scope.email);
    }
    $scope.$watch('email',this.validateEmail);
}