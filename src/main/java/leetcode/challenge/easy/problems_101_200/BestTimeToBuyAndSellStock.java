package main.java.leetcode.challenge.easy.problems_101_200;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        if(prices.length < 2) {
            return 0;
        }

        int buyCost = Integer.MAX_VALUE;
        int sellCost = 0;
        int profit = 0;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] < buyCost)  {
                /**
                 * you always want to buy at the lowest cost possible.
                 * So if you find a day where the price is lower than your current buying cost, buy on this day instead.
                 */
                buyCost = prices[i];
                sellCost = 0;
            } else if(prices[i] >= sellCost) {
                /**
                 * you always want to sell at the highest cost possible.
                 * So if you find a day that allows u to sell at a profit higher than your previously highest profit,
                 * set this as your selling price and recalculate the profits
                 */
                if(prices[i] - buyCost >= profit) {
                    sellCost = prices[i];
                    profit = prices[i] - buyCost;
                }
            }
        }

        return profit;
    }
}
