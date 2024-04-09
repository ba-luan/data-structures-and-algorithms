package dev.luka.leetcode.problems;

import java.util.*;

public class FindKPairsWithSmallestSums_373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Priority queue to store pairs (sum, i, j) where sum is the sum of nums1[i] and nums2[j]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(arr -> arr[0]));

        // Initialize the priority queue with the first k pairs formed by taking the first element of nums1 with each element of nums2
        for (int j = 0; j < Math.min(nums2.length, k); j++) {
            pq.offer(new int[]{nums1[0] + nums2[j], 0, j});
        }

        // Process the priority queue until we have found k smallest pairs
        while (k-- > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[1], j = pair[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Add the next pair formed by taking the next element of nums1 with nums2[j]
            if (i < nums1.length - 1) {
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums_373 solution = new FindKPairsWithSmallestSums_373();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println("K smallest pairs:");
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }

}
