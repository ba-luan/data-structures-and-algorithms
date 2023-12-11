package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i : counter) if (i != 0) return false;

        return true;
    }

    public static boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
            counter.put(t.charAt(i), counter.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int i : counter.values()) if (i != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car")); // false

        System.out.println(isAnagramHashMap("anagram", "nagaram")); // true
        System.out.println(isAnagramHashMap("rat", "car")); // false

    }

}
