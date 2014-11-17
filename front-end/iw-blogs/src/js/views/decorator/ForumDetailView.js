/**
 * Created by tuanlhd on 11/17/14.
 */
ForumDetailView.inheritsFrom(DecoratorView);
function ForumDetailView(view){
    this.baseView = view

    this.draw = function(data){
        //TODO it must draw data in view.
        console.log("drawing .");
        view.draw(data);
    }

    this.getInstance = function(){
        if(this.forumMenuView == null)
            this.forumMenuView = new ForumMenuView;
        return this.forumMenuView;
    }
}