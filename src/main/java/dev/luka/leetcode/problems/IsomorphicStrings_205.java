package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {

    public static boolean isIsomorphicFrequencyArray(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) return false;
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }
        return true;
    }
    /*
    Two strings are isomorphic if they have the same index pattern
    String 1:              A B E A C D B
    index pattern:         0 1 2 0 4 5 1
    String 2:              X Y I X H K Y
    index pattern:         0 1 2 0 4 5 1
    */
    public static boolean isIsomorphicIndexPattern(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // initialize -1 as placeholder index value then update it to correct index value later
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);

            // check if index pattern is matched
            if (indexS != indexT) return false;

            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        return true;
    }

    public static boolean isIsomorphicMapCharacterTwoWays(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (mapST.containsKey(cs) && mapST.get(cs) != ct) return false;
            if (mapTS.containsKey(ct) && mapTS.get(ct) != cs) return false;

            mapST.put(cs, ct);
            mapTS.put(ct, cs);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicFrequencyArray("egg", "add")); // true
        System.out.println(isIsomorphicFrequencyArray("foo", "bar")); // false
        System.out.println(isIsomorphicFrequencyArray("paper", "title")); // true

        System.out.println(isIsomorphicIndexPattern("egg", "add")); // true
        System.out.println(isIsomorphicIndexPattern("foo", "bar")); // false
        System.out.println(isIsomorphicIndexPattern("paper", "title")); // true

        System.out.println(isIsomorphicMapCharacterTwoWays("egg", "add")); // true
        System.out.println(isIsomorphicMapCharacterTwoWays("foo", "bar")); // false
        System.out.println(isIsomorphicMapCharacterTwoWays("paper", "title")); // true

    }
}
