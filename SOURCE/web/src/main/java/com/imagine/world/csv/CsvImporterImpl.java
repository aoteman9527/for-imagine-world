package com.imagine.world.csv;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.imagine.world.dao.ProductDAO;
import com.imagine.world.dao.impl.ProductDAOImpl;
import com.imagine.world.mapper.ProductMapper;
import com.imagine.world.models.Product;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

/**
 * Created by letuan on 2/21/14.
 */
public class CsvImporterImpl extends CsvImporter{

    static Logger LOGGER = Logger.getLogger(CsvImporterImpl.class.getName());

    /**
     *
     * @param pathToCsvFile direct to the file content products
     */
    public void process(String pathToCsvFile){
        Reader reader = null;
        try {
            reader = new FileReader(pathToCsvFile);
        } catch (FileNotFoundException e) {
            LOGGER.error("Reading file csv path ".concat(pathToCsvFile));
            return ;
        }

        CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);

        String[] rowCsv = null;
        Integer firstIndex = 0;
        try {
            while((rowCsv = csvParser.readNext())!=null){
//                System.out.println(Arrays.toString(rowCsv));

                LOGGER.info("import this row ".concat(Arrays.toString(rowCsv)));
                this.importDatabase(rowCsv[firstIndex].split(","));
            }
            csvParser.close();
        } catch (IOException e) {
            LOGGER.error("Reading each line of csv file previous row ".concat(Arrays.toString(rowCsv)));
            return;
        }
    //TODO : run unit test :D
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
