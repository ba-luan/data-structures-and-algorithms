package dev.luka.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] array) {
        int n = array.length;

        if (n <= 1) {
            return; // Base case: already sorted or single element
        }

        int mid = n / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[n - mid];

        // Divide the array into left and right halves
        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, n - mid);

        // Recursively sort the left and right halves
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge the sorted halves
        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        // Merge the two halves by comparing elements
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements from left and right arrays
        while (i < leftLength) {
            result[k++] = left[i++];
        }
        while (j < rightLength) {
            result[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
//        int[] array = { 12, 11, 13, 5, 6, 7 };
        Random rand = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

