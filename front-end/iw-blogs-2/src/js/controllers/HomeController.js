/**
 * Created by tuanlhd on 11/17/14.
 */
HomeController.inheritsFrom(BaseController);
function HomeController () {
    this.getViewHtml = function(){
        return "<img id=\"indexHome\" onload=\"include(this,this.id+'.html')\" src=\"img/apple-touch-icon-144-precomposed.png\" >";
    }

    this.setUpViews = function(){
        throw new Error("This function is not support")
    }
}
