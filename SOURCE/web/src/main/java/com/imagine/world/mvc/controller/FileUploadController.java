package com.imagine.world.mvc.controller;

import com.imagine.world.mvc.model.FileUploadForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController {

    static Logger LOGGER = Logger.getLogger(FileUploadController.class.getName());


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String displayForm() {
        return "csv/file_upload_form";
    }
     
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("uploadForm") FileUploadForm uploadForm,
                    Model map) {
         
        List<MultipartFile> files = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<>();
         
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                //Handle file content - multipartFile.getInputStream()
                LOGGER.info(" uploaded fileName ".concat(fileName));
            }
        }
         
        map.addAttribute("files", fileNames);
        return "csv/file_upload_success";
    }
}