package dev.luka.leetcode.problems;

import java.util.Arrays;

public class MergeSortedArray_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexTotal = m + n - 1;

        while (index2 >= 0) {
            if (index1 >= 0 && nums1[index1] > nums2[index2]) {
                nums1[indexTotal--] = nums1[index1--];
            } else {
                nums1[indexTotal--] = nums2[index2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;

        System.out.println("nums1:\n" + Arrays.toString(nums1));
        System.out.println("nums2:\n" + Arrays.toString(nums2));
        merge(nums1, m, nums2, n);
        System.out.println("resutl:\n" + Arrays.toString(nums1));
    }
}
