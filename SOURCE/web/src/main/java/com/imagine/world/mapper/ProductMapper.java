package com.imagine.world.mapper;

import com.imagine.world.config.ElementsCsvImporter;
import com.imagine.world.models.Product;

/**
 * Created by letuan on 2/22/14.
 */
public class ProductMapper {

    public static Product convertProductCsvToDao(String[] rowCsv){
        Product output = new Product();
        output.setProductAmount(Integer.parseInt(rowCsv[ElementsCsvImporter.ROW_PRODUCT_AMOUNT.getValueInt()]));
        output.setPrice(rowCsv[ElementsCsvImporter.ROW_PRICE.getValueInt()]);
        output.setProductCode(rowCsv[ElementsCsvImporter.ROW_PRODUCT_CODE.getValueInt()]);
        output.setName(rowCsv[ElementsCsvImporter.ROW_NAME.getValueInt()]);
        output.setDescription(rowCsv[ElementsCsvImporter.ROW_DESCRIPTION.getValueInt()]);
        output.setImageUrl(rowCsv[ElementsCsvImporter.ROW_IMAGE_URL.getValueInt()]);
        //output.setIdProduct();// -skip
        //output.setLastUpdateDate();//-skip
        return output;
    }

}
