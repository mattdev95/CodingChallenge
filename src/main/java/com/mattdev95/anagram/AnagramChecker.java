package com.mattdev95.anagram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 *
 */
public class AnagramChecker {

    private static final Logger LOGGER = LogManager.getLogger(AnagramChecker.class);
    // this will need to
    private final Scanner scanner = new Scanner(System.in);

    // global memory to mock cache
    private final ArrayList<String> stringCache = new ArrayList<>();

    /**
     * Main method to run program.
     */
    public void checkAnagramInput() throws IOException {
        // intitialise
        var filesCreator = new AnagramFileCreator();
        List<String> valuesEntered = filesCreator.readFromFile();
        stringCache.addAll(valuesEntered);
        System.out.println("---- Hello welcome to the anagram checker ----");
        System.out.print("Please enter your username > ");
        String username = scanner.nextLine();
        while(username.trim().isEmpty()) {
            System.out.println("Please re-enter username > ");
            username = scanner.nextLine();
        }
        System.out.println("Welcome " + username);
        System.out.println("Please enter two strings");
        System.out.print("Enter values one >");
        String textValueOne = scanner.nextLine();
        while((containsNumbers(textValueOne) || textValueOne.trim().isEmpty()) && !stringCache.contains(textValueOne)) {
            System.out.println("Please re-enter value one > ");
            textValueOne = scanner.nextLine();
        }
        updateCache(textValueOne);
        if(!valuesEntered.contains(textValueOne)) {
            filesCreator.writeToFile(textValueOne);
        }
        System.out.print("Enter value two >");
        String textValueTwo = scanner.nextLine();
        while((textValueOne.length() != textValueTwo.length() || containsNumbers(textValueTwo) || textValueOne.trim().isEmpty()) &&
        !stringCache.contains(textValueTwo)) {
            System.out.println();
            System.out.print("Please re-enter the second value > ");
            textValueTwo = scanner.nextLine();
        }
        updateCache(textValueTwo);
        if(!valuesEntered.contains(textValueTwo)) {
            filesCreator.writeToFile(textValueTwo);
        }
        char[] valueCharactersOne = createSortedCharacterList(textValueOne);
        char[] valueCharactersTwo = createSortedCharacterList(textValueTwo);
        Boolean isAnagram = analyseIfAnagram(valueCharactersOne, valueCharactersTwo);
        String result = resultsOfAnagramInput(isAnagram);
        // clear cache
        stringCache.clear();
        System.out.println(result);
        System.out.println("Goodbye " + username);
    }

    /**
     * To check if a string contains numbers
     * @param input
     * @return
     */
    private Boolean containsNumbers(String input) {
        return input.matches(".*\\d.*");
    }

    private char[] createSortedCharacterList(String value) {
        char[] valueToChars = value.toCharArray();
        Arrays.sort(valueToChars);
        return valueToChars;
    }


    private void updateCache(String value) {
        if(!stringCache.contains(value)) {
            stringCache.add(value);
        }
    }

    private Boolean analyseIfAnagram(char[] valueOne, char[] valueTwo) {
        // first need to check if both of the values are of the same length
        for(int i = 0; i < valueOne.length; i++){
            if(valueOne[i] != valueTwo[i]) {
                return false;
            }
        }
        LOGGER.debug("Anagram has been found.");
        return true;
    }

    private String resultsOfAnagramInput(Boolean result) {
        if(result) {
            return "Both values equal to an anagram.";
        }
        return "Both values do not equal to an anagram.";
    }
































}
