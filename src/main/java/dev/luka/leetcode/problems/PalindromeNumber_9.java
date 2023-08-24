package dev.luka.leetcode.problems;

public class PalindromeNumber_9 {
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;

            int reversed = 0;
            int temp = x;
            while(temp != 0) {
                int lastDigit = temp % 10; // get last digit
                reversed = reversed * 10 + lastDigit;
                temp /= 10; // truncate last digit
            }
            System.out.println(x + "\n" + reversed);
            return reversed == x;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().isPalindrome(1232));

    }

}
