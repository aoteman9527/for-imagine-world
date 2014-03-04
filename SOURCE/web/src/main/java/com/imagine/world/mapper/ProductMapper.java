package com.imagine.world.mapper;

import com.imagine.world.common.Elements;
import com.imagine.world.models.Product;

/**
 * Created by letuan on 2/22/14.
 */
public class ProductMapper {


    public static Product convertProductCsvToDao(String[] rowCsv){
        Product output = new Product();
        output.setProductAmount(Integer.parseInt(rowCsv[Elements.ROW_PRODUCT_AMOUNT]));
        output.setPrice(rowCsv[Elements.ROW_PRICE]);
        output.setProductCode(rowCsv[Elements.ROW_PRODUCT_CODE]);
        output.setName(rowCsv[Elements.ROW_NAME]);
        output.setDescription(rowCsv[Elements.ROW_DESCRIPTION]);
        //output.setIdProduct();// -skip
        //output.setLastUpdateDate();//-skip
        return output;
    }

}
