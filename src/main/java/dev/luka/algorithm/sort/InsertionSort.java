package dev.luka.algorithm.sort;


import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Insert key value to the right position.
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
//        int[] array = { 12, 11, 13, 5, 6 };

        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        System.out.println("Original array: " + Arrays.toString(array));

        insertionSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
