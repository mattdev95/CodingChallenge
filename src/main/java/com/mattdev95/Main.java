package com.mattdev95;
import com.mattdev95.anagram.AnagramChecker;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        var anagramChecker = new AnagramChecker();
        anagramChecker.checkAnagramInput();
    }
}
