package dev.luka.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    // Time Complexity is O(nlogn) due to sorting included
    // Space Complexity is O(1)
    public int longestConsecutiveSorting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int longestSteak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue; // skip duplicate numbers
            if (nums[i] - nums[i - 1] == 1) {
                currentStreak++;
            } else {
                longestSteak = Math.max(longestSteak, currentStreak);
                currentStreak = 1;
            }
        }

        // Need to check max again before returning, in case the longest streak ends at the end of array,
        // then the for loop will exit without updating the longestStreak value (in order word, it will not
        // go to the else statement)
        return Math.max(longestSteak, currentStreak);
    }

    public int longestConsecutiveHashSet(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // store all values in nums to a set
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int longestStreak = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) { // mean n doesn't have a number on its left; n is the start of a streak
                int streakLen = 0;
                while (set.contains(n + streakLen)){
                    streakLen++;
                }
                longestStreak = Math.max(longestStreak, streakLen);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 solution = new LongestConsecutiveSequence_128();

        System.out.println("With sorting:");
        System.out.println(solution.longestConsecutiveSorting(new int[]{100,4,200,1,3,2})); //4
        System.out.println(solution.longestConsecutiveSorting(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); //9

        System.out.println("\nUsing set:");
        System.out.println(solution.longestConsecutiveHashSet(new int[]{100,4,200,1,3,2})); //4
        System.out.println(solution.longestConsecutiveHashSet(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); //9
    }
}
