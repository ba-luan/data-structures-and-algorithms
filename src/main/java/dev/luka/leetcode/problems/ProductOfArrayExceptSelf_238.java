package dev.luka.leetcode.problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

    // Time O(n) Space O(n)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] ans = new int[n];

        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = leftProducts[i] * rightProducts[i];
        }

        return ans;
    }

    // Time O(n) Space O(1) exclude output array as extra space
    public static int[] productExceptSelf_V2(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = leftProduct; // update left product directly on ans array
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf_V2(nums)));

    }
}
