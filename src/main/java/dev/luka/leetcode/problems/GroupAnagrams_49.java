package dev.luka.leetcode.problems;

import java.util.*;

public class GroupAnagrams_49 {

    // Time Complexity O(m*nlogn) with m is the length of input array and n is average length of member strings
    // O(nlogn) comes from sorting each string in input array
    public List<List<String>> groupAnagramsWithSorting(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Time Complexity O(m*n)
    public List<List<String>> groupAnagramsWithoutSorting(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = new char[26];
            for (char c : s.toCharArray()) chars[c - 'a']++;
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        System.out.println(map.keySet());
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams_49 solution = new GroupAnagrams_49();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> withSorting = solution.groupAnagramsWithSorting(strs);
        List<List<String>> withoutSorting = solution.groupAnagramsWithoutSorting(strs);

        System.out.println("With sorting:\n" + withSorting);
        System.out.println("\nWithout sorting:\n" + withoutSorting);
    }

}
