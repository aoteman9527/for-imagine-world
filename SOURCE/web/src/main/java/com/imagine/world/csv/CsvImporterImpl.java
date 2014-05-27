package com.imagine.world.csv;

import com.imagine.world.dao.MyproductDao;
import com.imagine.world.mapper.ProductMapper;
import com.imagine.world.models.MyproductEntity;
import org.apache.log4j.Logger;

import java.sql.Date;
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
        MyproductDao myproductDao = new MyproductDao();
        MyproductEntity convertedProduct = ProductMapper.convertProductCsvToDao(record);
        List<MyproductEntity> foundProducts = myproductDao.getProductByProductCode(convertedProduct.getProductCode());
        int lastUpdateTime = new Long(System.currentTimeMillis()/1000).intValue();
        convertedProduct.setLastUpdateDate(new Date(lastUpdateTime));

        if(foundProducts!=null && foundProducts.size()>0){
            convertedProduct.setIdProduct(foundProducts.get(0).getIdProduct());
            myproductDao.update(convertedProduct);
        }else{
            myproductDao.insert(convertedProduct);

        }
    }


}
