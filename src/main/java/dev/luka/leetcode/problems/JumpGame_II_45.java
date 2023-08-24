package dev.luka.leetcode.problems;

public class JumpGame_II_45 {

    public static int jump(int[] nums) {
        int lastIndex = nums.length - 1;
        int jumps = 0;
        int currentJumpEnd = 0; // Ending position of the current jump
        int maxReach = 0; // Maximum index reachable using the current jump

        // we're only allowed to jump in range of value nums[i], no need to loop to the last index.
        for (int i = 0; i < lastIndex; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            // If the current position is the end of the current jump,
            // update the jump and the end of the next jump.
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = maxReach;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 2, 1, 1, 3, 9};
        int result = jump(nums);
        System.out.println("Minimum number of jumps: " + result);
    }

}
