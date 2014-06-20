package com.imagine.world.mvc.controller.bom;

import com.imagine.world.exception.LoginInvalidUserException;
import com.imagine.world.mvc.controller.BaseController;
import com.imagine.world.mvc.model.bom.ShopBOMModel;
import com.imagine.world.vbb.VbbClient;
import org.apache.http.HttpException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

/**
 * Created by letuan on 6/2/14.
 */
@Controller
@Scope("singleton")
@RequestMapping("/bom")
public class ShopBOMController extends BaseController{
    static Logger LOGGER = Logger.getLogger(ShopBOMController.class.getName());

    @Autowired
    ShopBOMModel shopBOMModel;

    @Autowired
    VbbClient vbbClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayForm(Model attributes) {

//        attributes.addAttribute(ElementsCsvImporter.FORM_ACTION_UPLOAD.getValue(), ElementsCsvImporter.PATH_NAME_CSV.getValue().concat(ElementsCsvImporter.PATH_NAME_SAVE.getValue()));
//        attributes.addAttribute("templatefile","csv/template.csv");
        return "bom/index";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public Object processPost(
            Model attributes, //for reponse
            @RequestParam(value = BOM_REQUEST_FILE, required = false) MultipartFile file,//only one file each upload
            @RequestParam(value = BOM_REQUEST_CLEAR, required = false) String clear//only one file each upload
    ) {
        if(file!=null) {
            shopBOMModel.addMultipartFileList(file);
            return shopBOMModel.getMultipartFileList().toString();
        }

        if(!StringUtils.isEmpty(clear)){
            shopBOMModel.clearMultipartFileList();
        }
        return "{}";
    }

    @RequestMapping(value = "testlogin", method = RequestMethod.GET)
    @ResponseBody
    public Object procesLogin(

    ) throws HttpException, IOException, URISyntaxException, LoginInvalidUserException {
        vbbClient.login("root","123456");
        return "{success:true}";

    }
}
