/**
 * Created by tuanlhd on 11/17/14.
 */
ForumMenuView.inheritsFrom(DecoratorView);
function ForumMenuView(view){
    this.baseView = view

    this.draw = function(data){

        console.log("drawing .");
        view.draw(data);
    }

}