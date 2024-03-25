package dev.luka.leetcode.problems;

public class SearchInRotatedSortedArray_33 {

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) { // left sub-array has completely ascending order
                if (target > nums[mid] || target < nums[l])
                    l = mid + 1;
                else
                    r = mid - 1;
            } else { // left sub-array contains the overlap of the end and start of the array
                if (target < nums[mid] || target > nums[r])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
