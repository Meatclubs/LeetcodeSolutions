package main.java.leetcode.algorithms.easy.problems_101_200;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Constraints:
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {

        int buyCost = Integer.MAX_VALUE;
        int sellCost = 0;
        int profit = 0;
        int totalProfit = 0;

        for(int i=0; i<prices.length; i++) {
            /**
             * Best time to buy is when the prices are lowest than your previously lowest recorded buying cost,
             * or when the price has just dropped from your previously highest recorded sell cost (such that you
             * sell on that day that you previously recorded the highest sell cost and buy again today).
             */
            if(prices[i] < buyCost || prices[i] < sellCost) {
                buyCost = prices[i];
                sellCost = 0;
                totalProfit += profit;
                profit = 0;
            } else {
                /**
                 * When the price is higher than your buy cost and higher than your previously recorded highest
                 * selling cost, this becomes your new selling day cost.
                 */
                sellCost = prices[i];
                profit = prices[i] - buyCost;
            }
        }

        /**
         * when you reach the last day, add to total profits the profit you will get from selling your currently
         * held stocks at the highest price recorded for it.
         */
        totalProfit += profit;

        return totalProfit;
    }
}
