package dev.luka.leetcode.problems;

import java.util.Arrays;

public class CoinChange_322 {

    public int coinChangeBottomUpDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // fill dp with dummy values that's greater than amount, it could be any value (i.e. Integer.MAX)
        // using (amount + 1) for memory efficiency wise
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // Base case: 0 coins needed to make up amount 0

        // Iterate through amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Iterate through coin denominations
            for (int coin : coins) {
                // Check if current amount is greater than or equal to current coin denomination
                if (i >= coin) {
                    // Update dp[i] with the minimum of current value and dp[i - coin] + 1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // dp[i - coin] + 1 means we add 1 more coin
                }
            }
        }

        // Return dp[amount] if it's less than the initialized large number, otherwise return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeTopDownDP(int[] coins, int amount) {
        // Initialize the memoization array to store the minimum coins needed for each amount
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);

        // Base case: 0 coins needed to make up amount 0
        memo[0] = 0;

        // Call the recursive function to find the minimum coins needed
        int minCoins = coinChangeTopDownDP(coins, amount, memo);

        // If minCoins is still Integer.MAX_VALUE, it means no combination of coins can make up the amount
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int coinChangeTopDownDP(int[] coins, int amount, int[] memo) {
        // If the minimum coins needed for the current amount is already calculated, return it
        if (memo[amount] != -1) {
            return memo[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        // Try using each coin denomination and recursively find the minimum coins needed
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int coinsNeeded = coinChangeTopDownDP(coins, amount - coin, memo);
                if (coinsNeeded != -1) {
                    minCoins = Math.min(minCoins, coinsNeeded + 1);
                }
            }
        }

        // Update memoization array
        memo[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        return memo[amount];
    }

    public static void main(String[] args) {
        CoinChange_322 sol = new CoinChange_322();
        System.out.println(sol.coinChangeBottomUpDP(new int[]{1,3,4,5}, 7));
        System.out.println(sol.coinChangeTopDownDP(new int[]{1,3,4,5}, 7));
    }
}
