package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

    public static boolean wordPatternCheckIndexPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map mapper = new HashMap();
        for (Integer i = 0; i < words.length; i++) {
            // put() method also returns the existing value of the key before updating to new value
            // if there's no existing value, put() method will return null
            // the condition below checks if the previous/most updated indexes of char and word are matched
            if (mapper.put(pattern.charAt(i), i) != mapper.put(words[i], i))
                return false;
        }
        return true;
    }

    public static boolean wordPatternMapTwoWays(String pattern, String s) {
        String[] words = s.split(" ");
        String[] pat = pattern.split("");
        if (pat.length != words.length) return false;

        Map charToWord = new HashMap<>();
        Map wordToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (charToWord.containsKey(pat[i]) && !charToWord.get(pat[i]).equals(words[i]))
                return false;
            if (wordToChar.containsKey(words[i]) && !wordToChar.get(words[i]).equals(pat[i]))
                return false;
            charToWord.put(pat[i], words[i]);
            wordToChar.put(words[i], pat[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPatternCheckIndexPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPatternCheckIndexPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPatternCheckIndexPattern("aaaa", "dog cat cat dog")); // false

        System.out.println(wordPatternMapTwoWays("abba", "dog cat cat dog")); // true
        System.out.println(wordPatternMapTwoWays("abba", "dog cat cat fish")); // false
        System.out.println(wordPatternMapTwoWays("aaaa", "dog cat cat dog")); // false
    }
}
