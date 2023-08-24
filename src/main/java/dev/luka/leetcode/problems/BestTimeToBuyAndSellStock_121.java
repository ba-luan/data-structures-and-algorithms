package dev.luka.leetcode.problems;

public class BestTimeToBuyAndSellStock_121 {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price seen so far
            } else {
                // Calculate the potential profit by selling at the current price
//                maxProfit = Math.max(maxProfit, price - minPrice);
                int todayProfit = price - minPrice;
                maxProfit = todayProfit > maxProfit ? todayProfit : maxProfit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println("Maximum Profit: " + result); // Output: Maximum Profit: 5
    }

}
