package dev.luka.leetcode.problems;

import java.util.Arrays;

public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as the reference for comparison.
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Compare the current string with the prefix.
            int j = 0;
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            // Update the prefix to be the common substring.
            prefix = prefix.substring(0, j);

            // If the prefix becomes an empty string, no more common prefix is possible.
            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }

    public String longestCommonPrefixV3(String[] strs) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != strs[0].charAt(i)) return res.toString();
            }
            res.append(strs[0].charAt(i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 solution = new LongestCommonPrefix_14();

        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"})); // returns "fl"
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"})); // returns ""

        System.out.println(solution.longestCommonPrefixV2(new String[]{"flower","flow","flight"})); // returns "fl"
        System.out.println(solution.longestCommonPrefixV2(new String[]{"dog","racecar","car"})); // returns ""

        System.out.println(solution.longestCommonPrefixV3(new String[]{"flower","flow","flight"})); // returns "fl"
        System.out.println(solution.longestCommonPrefixV3(new String[]{"dog","racecar","car"})); // returns ""
    }
}
