package dev.luka.leetcode.problems;

public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int lastNum = nums[nums.length - 1];
        for (int i = 1; i < nums.length && nums[i] <= lastNum; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
