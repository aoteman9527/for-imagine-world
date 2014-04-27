package com.imagine.world.web.csv;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.imagine.world.config.ElementsCsvImporter;
import com.imagine.world.csv.CsvImporter;
import com.imagine.world.csv.CsvImporterImpl;
import com.imagine.world.dao.ProductDAO;
import com.imagine.world.dao.impl.ProductDAOImpl;
import com.imagine.world.models.Product;
import junit.framework.TestCase;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by letuan on 2/27/14.
 */
public class CsvImporterImplTest extends TestCase{

    ProductDAO productDAO = new ProductDAOImpl();

    /**
     * Target of this test to read an input pathFile and push to database
     * Schedule :
     * 1. prepare sample csv file in /tmp/
     * 2.run process() , check the database is data imported ?
     */
    public void testIntegrationImportToDB() throws IOException {
        String pathToCsvFile =  ClassLoader.getSystemResource("templates/csv/template.csv").getPath();

        CsvImporter importer = new CsvImporterImpl();
        importer.process(pathToCsvFile);
        int lastUpdateDate = new Long(System.currentTimeMillis()/1000).intValue();

        CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(new FileReader(pathToCsvFile));
        String[] rowCsv = null;
        Integer firstIndex = 0, count;
        Product product = null;
        while((rowCsv = csvParser.readNext())!=null){
//                System.out.println(Arrays.toString(rowCsv));
            rowCsv = rowCsv[firstIndex].split(","); // get firstRow of rowCsv then split it by comma to get data
            product = productDAO.getProductByProductCode(rowCsv[ElementsCsvImporter.ROW_PRODUCT_CODE.getValueInt()]).get(0);
            assertEquals(new Integer(lastUpdateDate-10000)<product.getLastUpdateDate(),true);
            count = productDAO.deleteByProductCode(rowCsv[ElementsCsvImporter.ROW_PRODUCT_CODE.getValueInt()]);
            assertTrue(count>0);
        }
    }
}
