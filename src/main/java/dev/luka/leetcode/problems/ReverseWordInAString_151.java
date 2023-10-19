package dev.luka.leetcode.problems;

public class ReverseWordInAString_151 {

    public static String reverseWordsV1(String s) {
        String[] words = s.trim().split("\\s+");

        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    // two pointers solution, no trim(), no spit(), no StringBuilder
    public static String reverseWordsV2(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') {
                i++; // skip spaces
            }
            while (j < i || j < n && a[j] != ' ') {
                j++; // skip non spaces
            }
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') {
                j++;             // skip spaces
            }
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++]; // keep non spaces
            }
            while (j < n && a[j] == ' ') {
                j++;             // skip spaces
            }
            if (j < n) {
                a[i++] = ' ';   // keep only one space
            }
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsV1("the sky is blue"));
        System.out.println(reverseWordsV1("  hello world  "));
        System.out.println(reverseWordsV1("a good   example"));

        System.out.println(reverseWordsV2("the sky is blue"));
        System.out.println(reverseWordsV2("  hello world  "));
        System.out.println(reverseWordsV2("a good   example"));
    }

}
