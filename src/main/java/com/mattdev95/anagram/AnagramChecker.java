package com.mattdev95.anagram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Main class to run the application.
 */
public class AnagramChecker {

    private static final Logger LOGGER = LogManager.getLogger(AnagramChecker.class);

    // Global memory to mock cache
    private final ArrayList<String> stringCache = new ArrayList<>();

    /**
     * Main method to run program.
     */
    public void checkAnagramInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            final var filesCreator = new AnagramFileCreator();
            List<String> valuesEntered = filesCreator.readFromFile();
            final String fileName = "values.txt";
            loadCache(valuesEntered);
            System.out.println("---- Hello welcome to the anagram checker ----");
            System.out.print("Please enter your username > ");
            String username = scanner.nextLine();
            while(isWhiteSpace(username) || username.trim().isEmpty()) {
                System.out.print("Please re-enter username > ");
                username = scanner.nextLine();
            }
            System.out.println("Welcome " + username);
            System.out.println("Please enter two strings");
            System.out.print("Enter values one >");
            String textValueOne = scanner.nextLine();
            while(containsNumbers(textValueOne) || isWhiteSpace(textValueOne) || stringCache.contains(textValueOne) && textValueOne.trim().isEmpty()) {
                System.out.print("Please re-enter value one > ");
                textValueOne = scanner.nextLine();
            }
            updateCache(textValueOne);
            if(!valuesEntered.contains(textValueOne)) {
                filesCreator.writeToFile(textValueOne, fileName);
            }
            System.out.print("Enter value two > ");
            String textValueTwo = scanner.nextLine();
            while(((textValueOne.length() != textValueTwo.length() || containsNumbers(textValueTwo) || isWhiteSpace(textValueTwo)) ||
                    stringCache.contains(textValueTwo) && textValueTwo.trim().isEmpty())) {
                System.out.print("Please re-enter the second value > ");
                textValueTwo = scanner.nextLine();
            }
            updateCache(textValueTwo);
            if(!valuesEntered.contains(textValueTwo)) {
                filesCreator.writeToFile(textValueTwo, fileName);
            }
            Boolean isAnagram = analyseIfAnagram(textValueOne, textValueTwo);
            String result = resultsOfAnagramInput(isAnagram);
            stringCache.clear();
            System.out.println(result);
            System.out.println("Goodbye " + username);
        } catch (Exception e) {
            LOGGER.error("Something has gone wrong, please investigate", e);
        }
    }

    /**
     * To check if a string contains numbers
     * @param input the value to check if numbers exist.
     * @return the boolean result.
     */
    private Boolean containsNumbers(String input) {
        return input.matches(".*\\d.*");
    }

    /**
     * To check if there is a space entered within the input.
     * @param value to check.
     * @return boolean result if whitespace.
     */
    private Boolean isWhiteSpace(String value) {
        return value.matches(".*\\s+.*");
    }

    /**
     * To sort character array in alphabetical order.
     * @param value the value to enter.
     * @return sorted list.
     */
    private char[] createSortedCharacterList(String value) {
        char[] valueToChars = value.toCharArray();
        Arrays.sort(valueToChars);
        return valueToChars;
    }

    /**
     * Update cache.
     * @param value the value to enter to cache.
     */
    private void updateCache(String value) {
        if(!stringCache.contains(value)) {
            stringCache.add(value);
            LOGGER.debug("Cache has been updated with " + value);
        }
    }

    /**
     * To load the cache on startup
     * @param cacheValues the values to add to cache.
     */
    private void loadCache(List<String> cacheValues) {
        stringCache.addAll(cacheValues);
        LOGGER.debug("Cache has been loaded with existing entities: " + cacheValues);
    }

    /**
     * Check if the value is an anagram.
     * @param valueOne value to enter.
     * @param valueTwo value to enter.
     * @return the result if anagram, false if not
     */
    public Boolean analyseIfAnagram(String valueOne, String valueTwo) {
        char[] valueCharactersOne = createSortedCharacterList(valueOne);
        char[] valueCharactersTwo = createSortedCharacterList(valueTwo);
        // first need to check if both of the values are of the same length
        for(int i = 0; i < valueCharactersOne.length; i++){
            if(valueCharactersOne[i] != valueCharactersTwo[i]) {
                return false;
            }
        }
        LOGGER.debug("Anagram has been found.");
        return true;
    }

    /**
     * To return the result.
     * @param result the result.
     * @return the string result.
     */
    private String resultsOfAnagramInput(Boolean result) {
        if(result) {
            return "Both values equal to an anagram.";
        }
        return "Both values do not equal to an anagram.";
    }
































}
