package dev.luka.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }

        return set.isEmpty() ? (count * 2) : (count * 2 + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome_409 solution = new LongestPalindrome_409();
        System.out.println(solution.longestPalindrome("abccccdd")); //7
        System.out.println(solution.longestPalindrome("a")); //1
    }
}
