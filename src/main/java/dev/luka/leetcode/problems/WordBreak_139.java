package dev.luka.leetcode.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    /*
    * Time complexity O(2^n): where n is the length of string s. Because there are 2 ways to split a string length of n
    * into length of (n-1), similarly there are 2 ways to split string length of (n-1) into (n-2). E.g. given "abcd",
    * it can be split into {{"a", "bcd"}, {"abc", "d"}}; and "bcd" into {{"b", "cd"}, {"bc", "d"}}; and so on...
    * Space complexity O(n + m) where n is the size of recursion stack (also the length of string s) and m is size of set wordDict.
    * */
    public boolean wordBreakRecursion(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // contains() method in Set has time of O(1) whereas List has O(n)
        return wordBreakRecursion(s, wordSet);
    }

    private boolean wordBreakRecursion(String s, Set<String> wordSet) {
        // Base case: empty string can be segmented
        if (s.isEmpty()) return true;

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordSet.contains(prefix) && wordBreakRecursion(suffix, wordSet)) {
                return true;
            }
        }

        return false; // no segmentation found
    }

    /*
    * Dynamic Programming Solution: Time O(n^2) and Space O(n).
    * */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // indicating that an empty string can always be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak_139 sol = new WordBreak_139();
        System.out.println(sol.wordBreak("applepenapple", List.of("apple","pen")));
        System.out.println(sol.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
        System.out.println(sol.wordBreakRecursion("applepenapple", List.of("apple","pen")));
        System.out.println(sol.wordBreakRecursion("catsandog", List.of("cats","dog","sand","and","cat")));
    }

}
