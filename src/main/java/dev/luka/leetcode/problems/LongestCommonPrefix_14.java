package dev.luka.leetcode.problems;

import java.util.Arrays;

public class LongestCommonPrefix_14 {

    public static String longestCommonPrefix(String[] v) {
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

    public static String longestCommonPrefixV2(String[] strs) {
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


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"})); // returns "fl"
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"})); // returns ""

        System.out.println(longestCommonPrefixV2(new String[]{"flower","flow","flight"})); // returns "fl"
        System.out.println(longestCommonPrefixV2(new String[]{"dog","racecar","car"})); // returns ""
    }
}
