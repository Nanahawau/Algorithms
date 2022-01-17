package com.nana.arrays;

public class BuySellStocks {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
        //7,6,4,3,1
    }

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
     * the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *  System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int right = i + 1;

            int profit = prices [right] - prices[left];

            if (prices[left] < prices[right] && profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[left] > prices[right]) {
                left = right;
            }
        }
        return maxProfit;
    }

}
