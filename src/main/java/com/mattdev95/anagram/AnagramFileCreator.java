package com.mattdev95.anagram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramFileCreator {
    private static final Logger LOGGER = LogManager.getLogger(AnagramChecker.class);

    /**
     *
     * @param value
     */
    public void writeToFile(String valueOne) {
        try {
            BufferedWriter valueWriter = new BufferedWriter(new FileWriter("values.txt", true));
            valueWriter.write(valueOne);
            valueWriter.write(",");
            valueWriter.close();
        } catch (IOException e) {
            LOGGER.error("The values: " + valueOne + " was unable to be written to file", e);
        }
    }

    /**
     *
     * @return
     */
    public List<String> readFromFile() {
        try {
            BufferedReader valueReader = new BufferedReader(new FileReader("values.txt"));
            String values = valueReader.readLine();
            if(values != null) {
                String[] valuesArray = values.split(",");
                System.out.println(Arrays.toString(valuesArray));
                return Arrays.stream(valuesArray).collect(Collectors.toList());
            }
        } catch (IOException e) {
            LOGGER.error("File was unable to be read.", e);
        }
        LOGGER.debug("The file is empty");
        return new ArrayList<>();
    }

}
