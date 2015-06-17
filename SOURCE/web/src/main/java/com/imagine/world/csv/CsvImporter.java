package com.imagine.world.csv;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created by letuan on 2/21/14.
 */
public abstract class CsvImporter {

    static Logger LOGGER = Logger.getLogger(CsvImporter.class.getName());

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
                this.importRecord(rowCsv[firstIndex].split("\t"));
            }
            csvParser.close();
        } catch (IOException e) {
            LOGGER.error("Reading each line of csv file previous row ".concat(Arrays.toString(rowCsv)));
            return;
        }
        //TODO : run unit test :D
    }
    public abstract void importRecord(String[] record);

}
