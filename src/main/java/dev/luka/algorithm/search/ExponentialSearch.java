package dev.luka.algorithm.search;

public class ExponentialSearch {
    public static int exponentialSearch(int[] array, int target) {
        int n = array.length;

        // If the target is at the first element
        if (array[0] == target) {
            return 0;
        }

        // Find the range for binary search by doubling the index
        int i = 1;
        while (i < n && array[i] <= target) {
            i *= 2;
        }

        // Perform binary search within the identified range
        int left = i / 2;
        int right = Math.min(i, n - 1);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int target = 10;

        int index = exponentialSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}
