package dev.luka.algorithm.search;

public class TernarySearch {
    public static int ternarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (array[mid1] == target) {
                return mid1;
            } else if (array[mid2] == target) {
                return mid2;
            } else if (target < array[mid1]) {
                right = mid1 - 1;
            } else if (target > array[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return -1; // Target not found
    }

    public static int ternarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }

        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right - left) / 3;

        if (array[mid1] == target) {
            return mid1;
        } else if (array[mid2] == target) {
            return mid2;
        } else if (target < array[mid1]) {
            return ternarySearchRecursive(array, target, left, mid1 - 1);
        } else if (target > array[mid2]) {
            return ternarySearchRecursive(array, target, mid2 + 1, right);
        } else {
            return ternarySearchRecursive(array, target, mid1 + 1, mid2 - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int target = 10;

        System.out.println("ternarySearch: ");
        int index = ternarySearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }

        System.out.println("ternarySearchRecursive: ");
        index = ternarySearchRecursive(array, target, 0, array.length - 1);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}

