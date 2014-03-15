package com.imagine.world.mvc.controller;

import com.imagine.world.common.Elements;
import com.imagine.world.csv.CsvImporter;
import com.imagine.world.csv.CsvImporterImpl;
import com.imagine.world.mvc.model.FileUploadForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(Elements.PATH_NAME_CSV)
public class FileUploadController {

    static Logger LOGGER = Logger.getLogger(FileUploadController.class.getName());
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private CsvImporter csvImporter = new CsvImporterImpl();
    @RequestMapping(value = Elements.PATH_NAME_IMPORT, method = RequestMethod.GET)
    public String displayForm(Model attributes) {

        attributes.addAttribute(Elements.FORM_ACTION_UPLOAD,Elements.PATH_NAME_CSV.concat(Elements.PATH_NAME_SAVE));
        attributes.addAttribute("templatefile","csv/template.csv");
        return Elements.JSP_FILE_UPLOAD_FORM;
    }

    @RequestMapping(value = Elements.PATH_NAME_SAVE, method = RequestMethod.POST)
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

                String path = "/tmp/".concat(Elements.CSV_FILE_NAME + simpleDateFormat.format(new Date())).concat(".csv");
                try {
                    multipartFile.transferTo(new File(path));
                    csvImporter.process(path);
                    new File(path).renameTo(new File(path.concat(".done")));
                } catch (Exception e) {
                    LOGGER.error(" multipartFile.transferTo ".concat(fileName));
                    return Elements.JSP_FILE_UPLOAD_FAILURE;
                }
            }
        }

        map.addAttribute("files", fileNames);
        return Elements.JSP_FILE_UPLOAD_SUCCESS;
    }
}