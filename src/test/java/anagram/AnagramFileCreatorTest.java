package anagram;

import com.mattdev95.anagram.AnagramFileCreator;
import org.junit.jupiter.api.*;

public class AnagramFileCreatorTest {

    @Test
    @Order(1)
    @DisplayName("To test if the file can be written to")
    public void writeToFileTest() {
        AnagramFileCreator anagramFileCreator = new AnagramFileCreator();
        String value = "there";
        String fileName = "test.txt";
        Boolean result = anagramFileCreator.writeToFile(value, fileName);
        Assertions.assertTrue(result);
    }
}
