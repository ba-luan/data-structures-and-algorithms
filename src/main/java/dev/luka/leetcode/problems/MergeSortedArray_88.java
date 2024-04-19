package dev.luka.leetcode.problems;

import java.util.Arrays;

public class MergeSortedArray_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexTotal = m + n - 1;

        while (index2 >= 0) {
            /*
            The if-else condition here needs to be exact order to handle edge case where nums1.length > 0 but m = 0
            We check if index1 >= 0 then we MUST do decrement index1 immediately, therefore we include checking
            (nums1[index1] > nums2[index2]) instead of:
                (index1 >= 0 && nums1[index1] <= nums2[index2])
                    nums1[indexTotal--] = nums2[index2--]
            */
            if (index1 >= 0 && nums1[index1] > nums2[index2]) {
                nums1[indexTotal--] = nums1[index1--];
            } else {
                nums1[indexTotal--] = nums2[index2--]; // index2 decrement is safe here because outer while loop make sure index2 >= 0
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
