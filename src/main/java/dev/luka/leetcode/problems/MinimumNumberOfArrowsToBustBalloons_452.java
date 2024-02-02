package dev.luka.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBustBalloons_452 {

    public static int findMinShotsV1(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparing(p -> p[0])); // Sort balloons by theirs START points

        int shots = 1;
        int[] prevBalloon = points[0];

        for (int[] curBalloon : points) {
            if (curBalloon[0] > prevBalloon[1]) {
                shots++;
                prevBalloon = curBalloon;
            } else {
                prevBalloon[1] = Math.min(prevBalloon[1], curBalloon[1]);
            }
        }

        return shots;
    }

    public static int findMinShotsV2(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparing(p -> p[1])); // Sort balloons by theirs END points

        int shots = 1;
        int end = points[0][1];

        for (int cur = 1; cur < points.length; cur++) {
            // If the current balloon overlaps with the previous one, continue
            if (points[cur][0] <= end) {
                continue;
            }
            // If the current balloon does not overlap, shoot a new arrow
            shots++;
            end = points[cur][1];
        }

        return shots;
    }

    public static void main(String[] args) {
        int[][] points1 = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points2 = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points3 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};

        System.out.println(findMinShotsV1(points1)); // 2
        System.out.println(findMinShotsV1(points2)); // 4
        System.out.println(findMinShotsV1(points3)); // 2

        System.out.println(findMinShotsV2(points1)); // 2
        System.out.println(findMinShotsV2(points2)); // 4
        System.out.println(findMinShotsV2(points3)); // 2
    }
}
