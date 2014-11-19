/**
 * Created by tuanlhd on 11/17/14.
 */
HeaderView.inheritsFrom(DecoratorView);
function HeaderView(view){
    this.baseView = view

    this.draw = function(data){
        if(data.originalRequest && data.originalRequest == IW_HOST_CONTEXT_AUTHORIZE){

        }
        console.log("header drawing .");
        view.draw(data);
    }
}