/**
 * Created by tuanlhd on 11/17/14.
 */
ForumMenuView.inheritsFrom(DecoratorView);
function ForumMenuView(view){
    this.baseView = view

    this.draw = function(data){
        //TODO
        console.log("drawing .");
        view.draw(data);
    }

    this.getInstance = function(){
        if(this.forumMenuView == null)
            this.forumMenuView = new ForumMenuView;
        return this.forumMenuView;
    }
}