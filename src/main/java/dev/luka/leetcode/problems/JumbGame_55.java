package dev.luka.leetcode.problems;

public class JumbGame_55 {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach < i) return false; // cannot reach this position.
            if (maxReach < i + nums[i]) {
                maxReach = i + nums[i]; // update new max reach position.
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean result = canJump(nums);
        System.out.println("Can reach the last index: " + result); // Output: Can reach the last index: true
    }

}
