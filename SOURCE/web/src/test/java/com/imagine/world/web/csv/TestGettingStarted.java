package com.imagine.world.web.csv;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import junit.framework.TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by letuan on 2/18/14.
 */
public class TestGettingStarted extends TestCase{
    public void testReadFile() throws IOException, URISyntaxException {
        String path =  ClassLoader.getSystemResource("sample.csv").getPath();
        System.out.print(path);
        Reader reader = new FileReader(path);

        CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
        List<String[]> data = csvParser.readAll();
        assertEquals(data.size()>0,true);
    }

}
