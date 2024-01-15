package dev.luka.leetcode.problems;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);
            if (height[l] < height[r]) l++;
            else r--;
        }

        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater_11 container = new ContainerWithMostWater_11();
        System.out.println(container.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
    }
}
