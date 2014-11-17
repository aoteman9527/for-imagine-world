/**
 * Created by tuanlhd on 11/17/14.
 */
ForumController.inheritsFrom(BaseController);
function ForumController () {
    this.view = null;
    this.getViewHtml = function(){
        return "<img id=\"indexForum\" onload=\"include(this,this.id+'.html')\" src=\"img/apple-touch-icon-144-precomposed.png\" >";
    }

    this.setUpViews = function(){
        this.view = new IndexForumView();
        this.view = new ForumMenuView(this.view);
        this.view = new ForumDetailView(this.view);

    }
    this.setUpViews();
}
