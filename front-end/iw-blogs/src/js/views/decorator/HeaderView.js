/**
 * Created by tuanlhd on 11/17/14.
 */
HeaderView.inheritsFrom(DecoratorView);
function HeaderView(view){
    this.baseView = view

    this.draw = function(data){
        //TODO it must draw data in view.
        console.log("header drawing .");
        view.draw(data);
    }
}