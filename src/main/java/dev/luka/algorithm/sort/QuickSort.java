package dev.luka.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int randomIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivotValue = array[randomIndex];
        swap(array, randomIndex, highIndex);

        int pivotIndex = partition(array, lowIndex, highIndex, pivotValue);

        quickSort(array, lowIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, highIndex);

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivotValue) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            while (array[leftPointer] <= pivotValue && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivotValue && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        if(array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    public static void quickSortV2(int[] array) {
        quickSortV2(array, 0, array.length - 1);
    }

    private static void quickSortV2(int[] array, int low, int high) {
        if (low < high) {
            int randomIndex = new Random().nextInt(high - low) + low;
            swap(array, randomIndex, high);

            int pivotIndex = partitionV2(array, low, high);
            quickSortV2(array, low, pivotIndex - 1);
            quickSortV2(array, pivotIndex + 1, high);
        }
    }

    private static int partitionV2(int[] array, int low, int high) {
        int pivot = array[high];
        // This i index is used to keep track of the boundary between elements less than the pivot
        // and those greater than or equal to the pivot.
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        // move pivot value to the correct position.
        swap(array, i + 1, high);
        return i + 1; // return the index of pivot.
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
//        int[] array = { 10, 7, 8, 9, 1, 5 };
        Random rand = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        int[] array2 = new int[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);

        System.out.println("Original array:\n" + Arrays.toString(array));

        quickSort(array);
        quickSortV2(array2);

        System.out.println("Sorted array:\n" + Arrays.toString(array));
        System.out.println("Sorted array V2:\n" + Arrays.toString(array2));
    }
}
