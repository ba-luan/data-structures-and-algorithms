package dev.luka.leetcode.problems;

public class PlusOne_66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 9 will become 0, and iterating to the next digit.
            digits[i] = 0;
        }
        // if every element in array is 9, e.g. [9,9,9,9,...]
        // after loop it becomes all 0s, e.g. [0,0,0,0,...]
        // by default, new int[] has all elements equal to 0.
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
