package com.nateshao.sword_offer.topic_09_fib;

/**
 * @date Created by 邵桐杰 on 2021/11/19 12:26
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Solution {

    public static void main(String[] args) {
        int fib = fib(10);
        System.out.println("fib = " + fib);

        int fib2 = fib2(10);
        System.out.println("fib2 = " + fib2);
    }

    /**
     * 递归实现
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1, sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

}
