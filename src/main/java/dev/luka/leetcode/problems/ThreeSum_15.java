package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time Complexity Sort O(nlogn) + Loops O(n^2) = O(n^2)
* Space Complexity Sort O(1) or O(n) depends on sorting algorithm - Worst case is O(n)
* */
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            // trick: instead of checking (nums[i] == nums[i+1]) only we do as below
            // to ensure the while loop below will be executed in case input array has only 3 elements
            // and the 1st & 2nd elements are equal which combine with the 3rd is a result triplet (for example: [1,1,-2])
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // Skip duplicates for the second element
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // Skip duplicates for the third element
                    }
                    // Move pointers after skipping duplicates as above
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // increasing the sum by moving left pointer
                } else {
                    right--; // decreasing the sum by moving right pointer
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum = new ThreeSum_15();

        System.out.println("Example 1:");
        List<List<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        result.forEach(System.out::println); // [[-1,-1,2],[-1,0,1]]

        System.out.println("Example 2:");
        result = threeSum.threeSum(new int[]{0,0,0});
        result.forEach(System.out::println); // [[0,0,0]]
    }
}
