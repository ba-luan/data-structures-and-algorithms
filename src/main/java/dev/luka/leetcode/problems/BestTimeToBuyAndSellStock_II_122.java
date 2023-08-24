package dev.luka.leetcode.problems;

public class BestTimeToBuyAndSellStock_II_122 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // We can buy & sell immediately, so we calculate the profit of every 2 adjacent days.
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxProfit += profit; // add only positive profit to maxProfit.
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println("Maximum Profit: " + result); // Output: Maximum Profit: 7
    }

}
