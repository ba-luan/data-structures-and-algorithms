package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class RansomNote_383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] countCharacter = new int[26];
        for (char c : magazine.toCharArray()) {
            countCharacter[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (countCharacter[c - 'a'] == 0) return false;
            countCharacter[c - 'a']--;
        }

        return true;
    }

    public static boolean canConstrucHashMapSolution(String ransomNote, String magazine) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!counter.containsKey(c) || counter.get(c) == 0) return false;
            counter.put(c, counter.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b")); // false
        System.out.println(canConstruct("aa", "ab")); // false
        System.out.println(canConstruct("aa", "aab")); // true

        System.out.println(canConstrucHashMapSolution("a", "b")); // false
        System.out.println(canConstrucHashMapSolution("aa", "ab")); // false
        System.out.println(canConstrucHashMapSolution("aa", "aab")); // true

    }
}
