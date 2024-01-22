package dev.luka.leetcode.problems;

public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1); // compare minLen to the size of current sliding window
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 solution = new MinimumSizeSubarraySum_209();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = solution.minSubArrayLen(target, nums);

        System.out.println(result); // Output: 2
    }
}
