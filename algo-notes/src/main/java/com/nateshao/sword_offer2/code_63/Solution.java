package com.nateshao.sword_offer2.code_63;

/**
 * @date Created by 邵桐杰 on 2022/8/21 21:01
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/submissions/
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution {
    /**
     * 暴力破解
     * 直接双重循环比较
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (max < prices[j] - prices[i]) max = prices[j] - prices[i];
            }
        }
        return max;
    }

    /**
     * 动态规划
     * 1. 遍历一遍
     * 2. 判断比较最小值，如果前一位比后一位小，就更新最小值
     * 3. 更新利润，比较前一位与后一位比较，更新利润，取最大值
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - prices[i - 1]); // 更新利润，比较前一位与后一位比较，更新利润，取最大值
            if (prices[i] > prices[i - 1]) prices[i] = prices[i - 1]; //
        }
        return max;
    }

    /**
     * k神
     *
     * 前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
     * dp[i]=max(dp[i−1],prices[i]−min(prices[0:i]))
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int profix = 0; // 利润
        int cost = Integer.MAX_VALUE;   // 花费
        for (int price : prices) {
            cost = Math.min(cost, price);
            profix = Math.max(profix, price - cost);
        }
        return profix;
    }
}















