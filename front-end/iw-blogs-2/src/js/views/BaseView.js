/**
 * Created by tuanlhd on 11/17/14.
 */
function BaseView(){


    /**
     * You must implement this function for Decorator pattern
     */
    this.draw = function(data){
        throw new Error("this function is not implement")
    }
}