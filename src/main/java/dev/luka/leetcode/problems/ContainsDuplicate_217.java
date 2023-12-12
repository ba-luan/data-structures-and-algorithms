package dev.luka.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

    // Brute-force: Time O(n^2), Space O(1)
    public static boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // Sorting: Time O(nlogn), Space O(1)
    public static boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums); // this has O(nlogn) time complexity
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    // HashSet: Time O(n), Space O(n)
    public static boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> counter = new HashSet();
        for (int num : nums) {
            if(!counter.add(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicateBruteForce(new int[]{1,2,3,1})); // true
        System.out.println(containsDuplicateBruteForce(new int[]{1,2,3,4})); // false
        System.out.println(containsDuplicateBruteForce(new int[]{1,1,1,3,3,4,3,2,4,2})); //true

        System.out.println(containsDuplicateSorting(new int[]{1,2,3,1})); // true
        System.out.println(containsDuplicateSorting(new int[]{1,2,3,4})); // false
        System.out.println(containsDuplicateSorting(new int[]{1,1,1,3,3,4,3,2,4,2})); //true

        System.out.println(containsDuplicateHashSet(new int[]{1,2,3,1})); // true
        System.out.println(containsDuplicateHashSet(new int[]{1,2,3,4})); // false
        System.out.println(containsDuplicateHashSet(new int[]{1,1,1,3,3,4,3,2,4,2})); //true
    }
}
