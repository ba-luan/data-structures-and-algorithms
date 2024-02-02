package dev.luka.leetcode.problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII_80 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        /*
        Note: we compare nums[i] != nums[k - 2] instead of nums[i] != nums[i - 2]
        because pointer k keeps track of already updated elements. By comparing value at i with value at k-2
        before updating value at k, we can ensure element not being duplicated more than twice
        from the index k-2 to k. In other words, after k updates the same value twice, if the next number is
        the same number, we move to next interation. If the next number is different, we update value at k
        with new value and values at k-2 and k-1 are duplicates of old number.
        */
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums)); // output: [1,1,2,2,3]
    }
}
