package dev.luka.algorithm.search;

public class InterpolationSearch {
    public static int interpolationSearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right && target >= array[left] && target <= array[right]) {
            /*
            Estimate the position using interpolation formula:

            int deltaValue = (target - array[left]);
            int valueRange = (array[right] - array[left]);
            int weight = deltaValue / valueRange;
            int indexRange = (right - left);
            int pos = left + weight * indexRange;
            */
            int pos = left + ((target - array[left]) * (right - left)) / (array[right] - array[left]);

            if (array[pos] == target) {
                return pos; // Target found
            }

            if (array[pos] < target) {
                left = pos + 1; // Search in the right half
            } else {
                right = pos - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {

        /*
         Example of worst scenario: bias-distributed data and target is the second last element in array.
         Iterate to every element. Time complexity O(n) instead of average scenario O(log log n).
        */

        int[] array = { 2, 4, 6, 8, 10, 12, 14, 16, 18 , 20, 999999};
        int target = 20;

        int index = interpolationSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}

