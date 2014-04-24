package com.imagine.world.csv;

import com.imagine.world.dao.ProductDAO;
import com.imagine.world.dao.impl.ProductDAOImpl;
import com.imagine.world.mapper.ProductMapper;
import com.imagine.world.models.Product;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by letuan on 2/21/14.
 */
public class CsvImporterImpl extends CsvImporter{

    static Logger LOGGER = Logger.getLogger(CsvImporterImpl.class.getName());

    @Override
    public void importRecord(String[] record) {
        this.importDatabase(record);
    }

    /**
     *
     * @param record is each product need to be imported
     */
    private void importDatabase(String[] record){
        ProductDAO productDAO = new ProductDAOImpl();
        Product convertedProduct = ProductMapper.convertProductCsvToDao(record);
        List<Product> foundProducts = productDAO.getProductByProductCode(convertedProduct.getProductCode());
        int lastUpdateTime = new Long(System.currentTimeMillis()/1000).intValue();
        convertedProduct.setLastUpdateDate(lastUpdateTime);

        if(foundProducts!=null && foundProducts.size()>0){
            convertedProduct.setIdProduct(foundProducts.get(0).getIdProduct());
            productDAO.update(convertedProduct);
        }else{
            productDAO.save(convertedProduct);

        }
    }


}
