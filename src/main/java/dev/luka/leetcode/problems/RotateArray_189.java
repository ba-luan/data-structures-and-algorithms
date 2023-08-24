package dev.luka.leetcode.problems;

public class RotateArray_189 {

    /*
    Time O(n); Space O(n)
     */
    public void rotateArrayExtraArrayV1(int[] nums, int k) {
        int len = nums.length;
        int[] rotated = new int[len];
        k %= len;
        System.arraycopy(nums, len - k, rotated, 0, k);
        System.arraycopy(nums, 0, rotated, k, len - k);
        System.arraycopy(rotated, 0, nums, 0, len);
    }

    public static int[] rotateArrayExtraArrayV2(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    // Use the same index arithmetic with rotateArrayExtraArrayV2() but swap elements in-place
    // Time O(n); Space O(1)

    public static void rotateArrayCyclic(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;

        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // In-place solution: Time O(n); Space O(1)
    public static void rotateArrayReverse(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // First, reverse the entire array.
        // Then, reverse the first k elements and the remaining n - k elements separately.
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
