package dev.luka.leetcode.problems;

public class IndexOfFirstOccurrenceInString_28 {
    public static int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (hLen < nLen) return -1;
        for (int i = 0; i <= hLen - nLen; i++) {
            int k;
            // k must be less than nLen or OutOfIndexException will be thrown.
            for (k = 0; k < nLen && haystack.charAt(i + k) == needle.charAt(k); k++);
            // since for loop above can break before reaching nLen
            // need to check k with nLen before return the index of occurrence.
            if (k == nLen) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
}
