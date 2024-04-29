package dev.luka.leetcode.problems;

import java.security.PublicKey;

public class BestTimeToBuyAndSellStock_121 {

    // Time O(n), Space O(1)

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price seen so far
            } else {
                // Calculate the potential profit by selling at the current price
                int todayProfit = price - minPrice;
                maxProfit = Math.max(maxProfit, todayProfit);
            }
        }

        return maxProfit;
    }

    // Time O(n), Space O(1)
    public static int maxProfit2Pointers(int[] prices) {
        int buyIndex = 0;
        int sellIndex = 1;
        int maxProfit = 0;

        while (sellIndex < prices.length) {
            int profit = prices[sellIndex] - prices[buyIndex];

            if (prices[buyIndex] < prices[sellIndex]) {
                maxProfit = Math.max(maxProfit, profit); // if buy price < sell price => keep checking maxProfit
            } else {
                buyIndex = sellIndex; // if sell price < buy price => update buy price to the new low price
            }

            sellIndex++;
        }

        return maxProfit;
    }

    /*
    * Time O(n), Space O(1)
    *
    * To solve this problem using the Kadane's algorithm, we can convert it into a maximum subarray sum problem where
    * the array represents the daily price changes.
    * If currentProfit becomes negative, reset it to 0 since we don't want to sell the stock at a loss.
    * */
    public static int maxProfitKadaneAlgo(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitChange = prices[i] - prices[i - 1];
            currentProfit = Math.max(currentProfit + profitChange, 0);
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices)); // output: 5
        System.out.println(maxProfit2Pointers(prices));
        System.out.println(maxProfitKadaneAlgo(prices));
    }
}
