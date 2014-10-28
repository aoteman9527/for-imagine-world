package com.imagine.world.api;

import org.springframework.ui.ModelMap;

//@Controller
//@RequestMapping("/")
public class HelloWorldController extends BaseApi {

//    @RequestMapping(value = "welcome",method = RequestMethod.GET)
	public String helloWorld(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }

//    @RequestMapping(value = "shop",method = RequestMethod.GET)
    public String goToShop(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "shop";
    }


}
