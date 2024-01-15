package dev.luka.leetcode.problems;

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted_167 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) r--;
            else if (sum < target) l++;
            else return new int[]{l + 1, r + 1};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumII_InputArrayIsSorted_167 solution = new TwoSumII_InputArrayIsSorted_167();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,3,4}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1,0}, 9)));
    }
}
