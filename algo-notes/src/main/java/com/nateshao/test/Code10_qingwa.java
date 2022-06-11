package com.nateshao.test;

/**
 * @date Created by 邵桐杰 on 2022/6/2 8:55
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Code10_qingwa {
    public static void main(String[] args) {
        System.out.println("numWays(7) = " + numWays(7));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
        }
        return dp[n];
    }
}
