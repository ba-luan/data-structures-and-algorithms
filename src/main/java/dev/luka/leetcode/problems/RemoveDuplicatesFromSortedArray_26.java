package dev.luka.leetcode.problems;

public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int lastNum = nums[nums.length - 1];
        for (int i = 1; i < nums.length && nums[i] <= lastNum; i++) { // check nums[i] <= lastNum not required, it's for better average run time
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
