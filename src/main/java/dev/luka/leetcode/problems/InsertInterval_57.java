package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_57 {

    public int[][] insertV1(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int cur = 0;
        // add intervals before newInterval
        while (cur < intervals.length && intervals[cur][1] < newInterval[0]) {
            res.add(newInterval);
            cur++;
        }

        // merge overlap intervals with newInterval
        while (cur < intervals.length && intervals[cur][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[cur][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[cur][1]);
            cur++;
        }
        res.add(newInterval);

        // add remaining intervals after the newInterval
        while (cur < intervals.length) {
            res.add(intervals[cur]);
            cur++;
        }

        return res.toArray(new int[res.size()][2]);
    }

    public int[][] insertV2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean addedNewInterval = false;

        for (int[] curInterval : intervals) {
            if (curInterval[1] < newInterval[0] || addedNewInterval) {
                res.add(curInterval);
            } else if (newInterval[1] < curInterval[0]) {
                res.add(newInterval);
                res.add(curInterval);
                addedNewInterval = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], curInterval[0]);
                newInterval[1] = Math.max(newInterval[1], curInterval[1]);
            }
        }

        // the loop exits without adding newInterval, (1) in the if statement when newInterval is added at the end
        // of input array, (2) in the else statement when newInterval merges with the last interval.
        if (!addedNewInterval) {
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval_57 solution = new InsertInterval_57();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        System.out.println("Insert v1:");
        for (int[] interval : solution.insertV1(intervals, newInterval)) {
            System.out.print(Arrays.toString(interval)); // Output: [1, 5], [6, 9]
        }

        System.out.println("\nInsert v2:");
        for (int[] interval : solution.insertV2(intervals, newInterval)) {
            System.out.print(Arrays.toString(interval)); // Output: [1, 5], [6, 9]
        }
    }
}
