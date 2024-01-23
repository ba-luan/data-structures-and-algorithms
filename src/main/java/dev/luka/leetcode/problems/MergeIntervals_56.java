package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on the start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Add the non-overlapping interval to the result
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval to the result
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals_56 solution = new MergeIntervals_56();

        int[][] intervals = {{1, 3}, {15, 18}, {8, 10}, {2, 6}};
        System.out.println("Original intervals:");
        Arrays.stream(intervals).forEach(interval -> System.out.print(Arrays.toString(interval)));

        int[][] mergedIntervals = solution.merge(intervals);
        System.out.println("\nMerged intervals");
        Arrays.stream(mergedIntervals).forEach(interval -> System.out.print(Arrays.toString(interval)));
    }
}
