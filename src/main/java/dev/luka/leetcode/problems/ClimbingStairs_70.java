package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_70 {

    public int climbStairsRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }

    public int climbStairsMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairsMemoization(n, memo);
    }
    private int climbStairsMemoization(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, climbStairsMemoization(n - 1, memo) + climbStairsMemoization(n - 2, memo));
        }

        return memo.get(n);
    }

    public int climbStairsTabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] table = new int[n+1];
        table[0] = table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }

    public int climbStairsSpaceOptimization(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int first = 1, second = 1;

        for (int i = 2; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs_70 sol = new ClimbingStairs_70();
        int n = 5;
        System.out.println(sol.climbStairsRecursion(n));
        System.out.println(sol.climbStairsMemoization(n));
        System.out.println(sol.climbStairsTabulation(n));
        System.out.println(sol.climbStairsSpaceOptimization(n));
    }
}
