package com.nateshao.codetop;

public class Code15_maxProfit {
    /**
     * 121. 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int cost = Integer.MAX_VALUE;
        for (int price : prices) {
            cost = Math.min(price, cost);
            maxProfit = Math.max(price, price - cost);
        }
        return maxProfit;
    }
}
