package dev.luka.leetcode.problems;

public class IsSubsequence_392 {

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0 ) return true;
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
    }
}
