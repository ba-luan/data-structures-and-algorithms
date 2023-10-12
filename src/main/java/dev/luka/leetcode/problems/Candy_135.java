package dev.luka.leetcode.problems;

import java.util.Arrays;

public class Candy_135 {

    public static int candyTwoPass(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // each kid receives at least 1 candy

        // distribute candies from left to right
        for(int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // distribute candies from right to left
        for(int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }

        return totalCandies;
    }

    public static int candyOnePass(int[] ratings) {

        int n = ratings.length;
        int up = 0, down = 0, peak = 0;
        int totalCandies = 1; // constraints ratings.length >= 1 and each kid has at least 1 candy.

        for (int i = 1; i < n; i++) {
            int prev = ratings[i - 1];
            int curr = ratings[i];

            // going uphill
            if (prev < curr) {
                up += 1;
                down = 0;
                peak = up + 1; // add count of ups and 1 for the minimum each kid gets
                totalCandies += peak;
            } else if (prev == curr) {
                up = 0;
                down = 0;
                peak = 0;
                totalCandies += 1; // add 1 for the minimum each kid gets
            }
            // going down hill
            else {
                down += 1;
                up = 0;
                if (peak > down) {
                    // if peak is greater to downs, there's enough candies to distribute
                    totalCandies += down;
                } else {
                    // when downs greater than ups, the peak number is not enough to distribute
                    // we have to add 1 more candy to the peak-child
                    totalCandies += down + 1;
                }
            }
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        System.out.println("ups > downs");
        System.out.println(candyTwoPass(new int[]{1,2,3,4,3,2}));
        System.out.println(candyOnePass(new int[]{1,2,3,4,3,2}));

        System.out.println("ups = downs");
        System.out.println(candyTwoPass(new int[]{1,2,3,2,1}));
        System.out.println(candyOnePass(new int[]{1,2,3,2,1}));

        System.out.println("has plateau");
        System.out.println(candyTwoPass(new int[]{1,2,3,3,2,1}));
        System.out.println(candyOnePass(new int[]{1,2,3,3,2,1}));

        System.out.println("ups < downs");
        System.out.println(candyTwoPass(new int[]{1,2,5,4,3,2,1}));
        System.out.println(candyOnePass(new int[]{1,2,5,4,3,2,1}));
    }
}
