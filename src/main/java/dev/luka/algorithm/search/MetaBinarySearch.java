package dev.luka.algorithm.search;

public class MetaBinarySearch {
    public static int metaBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        int exponent = 0; // Exponential factor

        while (left <= right) {
            // Exponential adjustment: bitwise left shift operand by 1 equals to time 2 each iteration.
            int mid = left + (1 << exponent);

            // adjust mid equal to right if the exponential increment make it out of bound.
            if (mid >= right) {
                mid = right;
            }

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                left = mid + 1;
                exponent++;
            } else {
                right = mid - 1;
                exponent++;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
        int target = 64;

        int index = metaBinarySearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}

