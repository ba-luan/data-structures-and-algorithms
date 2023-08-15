package dev.luka.algorithm.search;

/*
Sentinel Search improve Average Time Complexity by eliminate the comparison of the index if it reaches the array length.
By doing that, it only compares element value in the array with the target value, in which improves the performance.
*/

public class SentinelSearch {
    public static int sentinelSearch(int[] array, int target) {
        int lastIndex = array.length - 1;

        // Add sentinel at the end
        int originalLastValue = array[lastIndex];
        array[lastIndex] = target;

        int index = 0;
        while (array[index] != target) {
            index++;
        }

        // Restore the original last value
        array[lastIndex] = originalLastValue;

        if (index < lastIndex || array[lastIndex] == target) {
            return index; // Target found
        } else {
            return -1;    // Target not found
        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int target = 12;

        int index = sentinelSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}

