package dev.luka.leetcode.problems;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {

    /*
    * Time O(n^2) because we have nested loop
    * Space O(n) to store dp array with the length of nums
    * */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // fill with 1s as the minimum length of an increasing subsequence is 1.

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence_300 sol = new LongestIncreasingSubsequence_300();
        System.out.println(sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
