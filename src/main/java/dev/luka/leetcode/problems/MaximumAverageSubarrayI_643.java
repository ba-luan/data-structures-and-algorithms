package dev.luka.leetcode.problems;

public class MaximumAverageSubarrayI_643 {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        int max = sum;

        int windowLeft = 0;
        int windowRight = k;
        // In the 1st iteration of while loop, we actually start from the 2nd window (from index 1 to index k)
        // that's why we subtract nums[0] then add num[k]
        // the 1st window was calculated above to initialize the first max value
        while (windowRight < nums.length) {
            sum -= nums[windowLeft];
            sum += nums[windowRight];
            windowLeft++;
            windowRight++;
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4)); // 12.75
    }
}
