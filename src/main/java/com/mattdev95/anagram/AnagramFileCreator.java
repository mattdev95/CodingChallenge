package com.mattdev95.anagram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To write and read from files.
 */
public class AnagramFileCreator {

    private static final Logger LOGGER = LogManager.getLogger(AnagramChecker.class);

    /**
     * To write a file
     * @param valueOne the value to enter.
     * @param fileName the value to enter.
     */
    public Boolean writeToFile(String valueOne, String fileName) {
        try {
            BufferedWriter valueWriter = new BufferedWriter(new FileWriter(fileName, true));
            valueWriter.write(valueOne);
            valueWriter.write(",");
            valueWriter.close();
            return true;
        } catch (IOException e) {
            LOGGER.error("The values: " + valueOne + " was unable to be written to file", e);
        }
        return false;
    }

    /**
     * To read from the file.
     * @return return a list of values.
     */
    public List<String> readFromFile() {
        try {
            BufferedReader valueReader = new BufferedReader(new FileReader("values.txt"));
            String values = valueReader.readLine();
            if(values != null) {
                String[] valuesArray = values.split(",");
                return Arrays.stream(valuesArray).collect(Collectors.toList());
            }
        } catch (IOException e) {
            LOGGER.error("File was unable to be read.", e);
        }
        LOGGER.debug("The file is empty");
        return new ArrayList<>();
    }

}
