package dev.luka.algorithm.search;

public class JumpSearch {
    public static int jumpSearch(int[] array, int target) {
        int n = array.length;
        int blockSize = (int) Math.sqrt(n); // Calculate block size

        int step = blockSize;
        int prev = 0;

        // Jump forward in blocks
        while (array[Math.min(step, n) - 1] < target) {
            prev = step;
            step += blockSize;

            if (prev >= n) {
                return -1; // Target not found
            }
        }

        // Linear search within the identified block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (array[i] == target) {
                return i; // Target found
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int target = 10;

        int index = jumpSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}

