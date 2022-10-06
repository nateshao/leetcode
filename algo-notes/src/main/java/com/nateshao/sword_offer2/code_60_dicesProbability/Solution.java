package com.nateshao.sword_offer2.code_60_dicesProbability;

/**
 * @date Created by 邵桐杰 on 2022/10/3 15:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 */
public class Solution {
    /**
     * 解法2：动态规划（一维数组）
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        if (n == 0) return new double[0];
        double[] dp = new double[6 * n + 1];
        double[] ans = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
            ans[i - 1] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * n; j >= 1; j--) {
                int temp = 0;
                for (int k = 1; k <= 6; k++) {
                    temp += (j >= k) ? dp[j - k] : 0;
                }
                dp[j] = temp;
                if (i == n && j >= n) {
                    ans[j - i] = dp[j] / all;
                }
            }
        }
        return ans;
    }


    /**
     * 二维数组
     * 解法1：动态规划（二维数组） **【核心思想】**
     *
     * @param n
     * @return
     */
    public double[] dicesProbability2(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        double[] ans = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] += j >= k ? dp[i - 1][j - k] : 0;
                    if (i == n)
                        ans[j - i] = dp[i][j] / all;
                }
            }
        }
        return ans;
    }
}
