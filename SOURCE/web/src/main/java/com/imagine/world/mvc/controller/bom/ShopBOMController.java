package com.imagine.world.mvc.controller.bom;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;

/**
 * Created by letuan on 6/2/14.
 */
@Controller
@RequestMapping("/bom")
public class ShopBOMController {
    static Logger LOGGER = Logger.getLogger(ShopBOMController.class.getName());
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayForm(Model attributes) {

//        attributes.addAttribute(ElementsCsvImporter.FORM_ACTION_UPLOAD.getValue(), ElementsCsvImporter.PATH_NAME_CSV.getValue().concat(ElementsCsvImporter.PATH_NAME_SAVE.getValue()));
//        attributes.addAttribute("templatefile","csv/template.csv");
        return "bom/index";
    }
}
