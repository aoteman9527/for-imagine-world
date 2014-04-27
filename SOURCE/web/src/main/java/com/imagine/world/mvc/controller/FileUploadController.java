package com.imagine.world.mvc.controller;

import com.imagine.world.config.ElementsCsvImporter;
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
@RequestMapping("/csv")
public class FileUploadController {

    static Logger LOGGER = Logger.getLogger(FileUploadController.class.getName());
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private CsvImporter csvImporter = new CsvImporterImpl();
    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String displayForm(Model attributes) {

        attributes.addAttribute(ElementsCsvImporter.FORM_ACTION_UPLOAD.getValue(), ElementsCsvImporter.PATH_NAME_CSV.getValue().concat(ElementsCsvImporter.PATH_NAME_SAVE.getValue()));
        attributes.addAttribute("templatefile","csv/template.csv");
        return ElementsCsvImporter.JSP_FILE_UPLOAD_FORM.getValue();
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

                String path = "/tmp/".concat(ElementsCsvImporter.CSV_FILE_NAME.getValue() + simpleDateFormat.format(new Date())).concat(".csv");
                try {
                    multipartFile.transferTo(new File(path));
                    csvImporter.process(path);
                    new File(path).renameTo(new File(path.concat(".done")));
                } catch (Exception e) {
                    LOGGER.error(" multipartFile.transferTo ".concat(fileName));
                    return ElementsCsvImporter.JSP_FILE_UPLOAD_FAILURE.getValue();
                }
            }
        }

        map.addAttribute("files", fileNames);
        return ElementsCsvImporter.JSP_FILE_UPLOAD_SUCCESS.getValue();
    }
}