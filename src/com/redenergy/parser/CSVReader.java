/**
 * 
 */
package com.redenergy.parser;

import static java.util.Objects.isNull;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;



/**
 * Reader to read from CSV file.
 */
public class CsvReader implements Reader {
    private File csvFile;
    private final Logger logger = LoggerFactory.getLogger(CsvReader.class);

    public CsvReader() {
    }


    @Override
    public void setFile(File file) {
        this.csvFile = file;
    }

    /**
     * Read all lines from csv.
     *
     * @return all lines as String array.
     */
    @Override
    public List<String[]> readLines() throws Exception {

        if (isNull(csvFile)) {
            throw new Exception("Input csv file cant be null");
        }
        //logger.info("Started reading the csv file '{}'", csvFile.getName());
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            return reader.readAll();
        } catch (IOException e) {
            throw new SimpleNemParserException("Exception reading the csvfile ", e);
        }
    }
}