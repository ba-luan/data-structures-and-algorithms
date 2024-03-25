package dev.luka.leetcode.problems;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target){
        int i = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            if (nums[mid] == target) i = mid;
        }
        return i;
    }

    private static int findLast(int[] nums, int target){
        int i = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            if (nums[mid] == target) i = mid;
        }
        return i;
    }

    public static int[] searchRangeV2(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[]{left, right};
    }

    private static int binarySearch(int[] nums, int target, boolean leftBiased) {
        int l = 0;
        int r = nums.length - 1;
        int i = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid])
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
            else {
                i = mid;
                if (leftBiased)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] res1 = searchRange(new int[]{5,7,7,8,8,10}, 8);
        int[] res2 = searchRangeV2(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }
}
