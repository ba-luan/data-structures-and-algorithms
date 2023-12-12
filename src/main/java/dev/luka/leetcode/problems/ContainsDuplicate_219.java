package dev.luka.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_219 {

    // Using HashSet: Time O(n), Space O(k) because we'll keep track the size of sliding window should not grater than k
    public static boolean containsDuplicateV1(int[] nums, int k) {
        // base cases based on constraints
        // both conditions below to ensure indexes i & j are always not equal
        if (nums.length < 2 || k == 0) return false;

        Set<Integer> set = new HashSet();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // maintain the correct size k of sliding window
            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
            if (set.contains(nums[right])) return true;
            set.add(nums[right]);
        }

        return false;
    }

    public static boolean containsDuplicateV2(int[] nums, int k) {
        if (nums.length < 2 || k == 0) return false;

        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            // when i > k then i become right side of the sliding window
            // we have to remove elements from the left side of k, so we can only check elements from k to i
            if (i > k) set.remove(nums[i-k-1]);

            // if i < k, absolute of any two indexes always less than k
            // we don't have to check if two indexes are different, only checking if the number's in the set
            if(!set.add(nums[i])) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicateV1(new int[]{1,2,3,1}, 3)); //true
        System.out.println(containsDuplicateV1(new int[]{1,0,1,1}, 1)); //true
        System.out.println(containsDuplicateV1(new int[]{1,2,3,1,2,3}, 2)); // false

        System.out.println(containsDuplicateV2(new int[]{1,2,3,1}, 3)); //true
        System.out.println(containsDuplicateV2(new int[]{1,0,1,1}, 1)); //true
        System.out.println(containsDuplicateV2(new int[]{1,2,3,1,2,3}, 2)); // false

    }
}







