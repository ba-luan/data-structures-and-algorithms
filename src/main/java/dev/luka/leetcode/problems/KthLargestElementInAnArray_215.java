package dev.luka.leetcode.problems;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {

    // Time O(nlogk): needs to iter through the whole array, in each iteration, take O(logk) to perform offer/poll
    // k is the size of the Heap
    // Space O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray_215 sol = new KthLargestElementInAnArray_215();
        System.out.println(sol.findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // output: 5
        System.out.println(sol.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); //output: 4
    }
}
