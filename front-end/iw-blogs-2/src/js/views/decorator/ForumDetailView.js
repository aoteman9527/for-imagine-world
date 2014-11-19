/**
 * Created by tuanlhd on 11/17/14.
 */
ForumDetailView.inheritsFrom(DecoratorView);
function ForumDetailView(view){
    this.baseView = view

    this.draw = function(data){
        //TODO it must draw data in view.
        if(data instanceof TopicList){
            var list = data.data;

            var tableTopicList = jQuery("#tableTopicList");
        }
        console.log("drawing .");
        view.draw(data);
    }

}