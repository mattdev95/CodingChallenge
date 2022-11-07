package anagram;

import com.mattdev95.anagram.AnagramChecker;
import org.junit.jupiter.api.*;


public class AnagramCheckerTest {

    @Test
    @Order(1)
    @DisplayName("To test if the result is an anagram")
    public void testWhenAnagram() {
        AnagramChecker anagramChecker = new AnagramChecker();
        String valueOne = "friend";
        String valueTwo = "finder";
        Boolean result = anagramChecker.analyseIfAnagram(valueOne, valueTwo);
        Assertions.assertTrue(result);
    }

    @Test
    @Order(2)
    @DisplayName("To test if the result is not an anagram")
    public void testWhenNotAnagram() {
        AnagramChecker anagramChecker = new AnagramChecker();
        String valueOne = "hello";
        String valueTwo = "there";
        Boolean result = anagramChecker.analyseIfAnagram(valueOne, valueTwo);
        Assertions.assertFalse(result);
    }



}
