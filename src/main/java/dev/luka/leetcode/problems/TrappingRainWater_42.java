package dev.luka.leetcode.problems;

public class TrappingRainWater_42 {

    public static int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int trappedWater = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // returns 6
        System.out.println(trap(new int[]{4,2,0,3,2,5})); // returns 9

    }
}
