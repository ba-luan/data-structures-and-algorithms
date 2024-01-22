package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            /*
             * Move the left pointer to the right of the previous occurrence
             *
             * NOTE: we need to calculate the max of left pointer and currentChar's index
             * because the NEW repeated char may have smaller index than the left pointer.
             * Example: in substring "a--b-b--a" after we move left pointer to the right of the 1st 'b'
             * then we encounter NEW 'a' which has previous occurrence's index smaller than left pointer.
             * If we update left pointer to the right of the 1st 'a', we also include repeated 'b'.
             * */
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(charIndexMap.get(currentChar) + 1, left);
            }

            // Update the character's last seen index
            charIndexMap.put(currentChar, right);

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringV2(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            /*
            * The while loop keeps removing characters from the set and move the left pointer until it
            * eventually removes the duplicated character. This is equivalent to move the left pointer to the right of
            * the previous occurrence which is similar to the if condition in the method above.
            * This method is more intuitive but less efficient compared to above method.
            * */
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatedCharacters_3 solution = new LongestSubstringWithoutRepeatedCharacters_3();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(solution.lengthOfLongestSubstringV2("abcabcbb")); // Output: 3

        System.out.println(solution.lengthOfLongestSubstring("abba")); // Output: 2
        System.out.println(solution.lengthOfLongestSubstringV2("abba")); // Output: 2
    }
}
