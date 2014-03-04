package com.imagine.world.web.csv;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by letuan on 2/18/14.
 */
public class TestGettingStarted extends TestCase{
    static Logger LOGGER = Logger.getLogger(TestGettingStarted.class.getName());

    public void testReadFile() throws IOException, URISyntaxException {
        String path =  ClassLoader.getSystemResource("sample.csv").getPath();
        System.out.print(path);
        Reader reader = new FileReader(path);

        CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
        List<String[]> data = csvParser.readAll();
        assertEquals(data.size()>0,true);
    }

    public void testReadNextCsv() throws IOException {
        String path =  ClassLoader.getSystemResource("sample.csv").getPath();
        System.out.print(path);
        Reader reader = new FileReader(path);

        CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
        String[] rowCsv = null;
        while((rowCsv = csvParser.readNext())!=null){
            System.out.println(Arrays.toString(rowCsv));
        };
    }

    public void testReadFileTmp(){
        String path = "/tmp/";
        File tempDir = new File(path);
        File[] files = tempDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".csv");
            }
        });
    }

    public void testLoggingTofile(){
        for (int i=0;i<20000;i++){
            LOGGER.info("SOmething");
            LOGGER.error("SOmething");
            LOGGER.debug("SOmething");
            LOGGER.warn("SOmething");
        }

        //then check file log4j.properties to know more info
    }
}
