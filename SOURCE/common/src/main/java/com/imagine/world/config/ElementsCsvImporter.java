package com.imagine.world.config;

/**
 * Created by letuan on 4/27/14.
 */
public enum ElementsCsvImporter {

    CSV_FILE_NAME("products-"),
    ROW_PRICE("3"),
    ROW_PRODUCT_AMOUNT("5"),
    ROW_PRODUCT_CODE("4"),
    ROW_NAME("1"),
    ROW_DESCRIPTION("2"),
    ROW_IMAGE_URL("6"),
    PATH_NAME_CSV("/csv"),
    PATH_NAME_IMPORT("/import"),
    PATH_NAME_SAVE("/save"),
    JSP_FILE_UPLOAD_FORM("csv/file_upload_form"),
    JSP_FILE_UPLOAD_SUCCESS("csv/file_upload_success"),
    JSP_FILE_UPLOAD_FAILURE("csv/file_upload_failure"),
    FORM_ACTION_UPLOAD("actionUpload")
    ;

    private String value;

    private ElementsCsvImporter(String value){
        this.value = value;
    }

    public String getValue() { return value; }
    public Integer getValueInt() { return Integer.parseInt(value); }

    public void setValue(String value) { this.value = value; }

}
