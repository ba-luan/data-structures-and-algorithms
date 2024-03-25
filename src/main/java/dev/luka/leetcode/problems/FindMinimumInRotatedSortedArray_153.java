package dev.luka.leetcode.problems;

public class FindMinimumInRotatedSortedArray_153 {

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // if value at index left is greater than at index right, the array is rotated
        while (nums[l] > nums[r]) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r])
                r = m; // update r = m instead (m - 1) because m could be also the min value
            else
                l = m + 1;
        }

        // value at index left is less than or equal to at index right, array is sorted, min is at the upmost left index
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }

}
