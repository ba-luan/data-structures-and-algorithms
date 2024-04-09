package dev.luka.leetcode.problems;

import java.util.Arrays;

public class HouseRobber_198 {

    public int robRecursion(int[] nums) {
        return robRecursion(nums, nums.length - 1);
    }

    private int robRecursion(int[] nums, int i) {
        if (i < 0) return 0;

        int robCurrentHouse = nums[i] + robRecursion(nums, i - 2);
        int notRobCurrentHouse = robRecursion(nums, i - 1);

        return Math.max(robCurrentHouse, notRobCurrentHouse);
    }

    public int robMemoization(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robMemoization(nums, memo, nums.length - 1);
    }

    private int robMemoization(int[] nums, int[] memo, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(robMemoization(nums, memo, i - 2) + nums[i], robMemoization(nums, memo, i - 1));
        memo[i] = result;
        return result;
    }

    public int robIterativeMemo(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }

    public int robIterative2Variables(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber_198 sol = new HouseRobber_198();
        int[] nums = {1,2,3,1};
        System.out.println(sol.robRecursion(nums));
        System.out.println(sol.robMemoization(nums));
        System.out.println(sol.robIterativeMemo(nums));
        System.out.println(sol.robIterative2Variables(nums));
    }
}
