package com.imagine.world.csv;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
        }

        CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
        String[] rowCsv = null;
        try {
            while((rowCsv = csvParser.readNext())!=null){
                //TODO : call add to database
                System.out.println(Arrays.toString(rowCsv));
            }
        } catch (IOException e) {
            LOGGER.error("Reading each line of csv file previous row ".concat(Arrays.toString(rowCsv)));
        }

    }

    /**
     *
     * @param record is each product need to be imported
     */
    private void importDatabase(String[] record){
        
    }



}
