package com.imagine.world.common;

/**
 * Created by letuan on 2/22/14.
 */
public class Elements {
    //this defined name of each uploaded csv product file
    public static String CSV_FILE_NAME = "products-";

    // this Static Variable for index of Product data from CSV file need to imported database
    public static Integer ROW_PRICE = 3, ROW_PRODUCT_AMOUNT=5, ROW_PRODUCT_CODE=4, ROW_NAME=1,
            ROW_DESCRIPTION=2,ROW_IMAGE_URL=6;

    //This variable for PATH SERVICE
    public final static String PATH_NAME_CSV="/csv", PATH_NAME_IMPORT="/import", PATH_NAME_SAVE = "/save";

    //This variable for Path View JSTL
    public static String JSP_FILE_UPLOAD_FORM = "csv/file_upload_form",
            JSP_FILE_UPLOAD_SUCCESS = "csv/file_upload_success",
            JSP_FILE_UPLOAD_FAILURE = "csv/file_upload_failure"
    ;

    //FROM action or other request variable set for View
    public static String FORM_ACTION_UPLOAD="actionUpload";


}
