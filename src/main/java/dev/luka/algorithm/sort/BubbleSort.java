package dev.luka.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) { // ONLY loop through the unsorted part of array
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // This version has slower Average time because in each iteration it checks the whole array
    // if there's any swap happens
    public static void bubbleSortV2(int[] array) {
        int len = array.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < len - 1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100000);
        }
        System.out.println("Original array: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

