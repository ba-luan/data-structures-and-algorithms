package dev.luka.leetcode.problems;

public class MoveZeroes_283 {

    public void moveZeroes_twoLoops(int[] nums) {
        // move all non-zero number to the left using pointer i.
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        // change the rest number to zero.
        while(i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

    public void moveZeros_oneLoop(int[] nums) {
        // keep track of number of consecutive zeros
        // then swap non-zero number to the up most left of this zeros sequence.
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - zeroCount] = temp; // assign non-zero to the up most left of zero-sequence
            }
        }
    }

}
