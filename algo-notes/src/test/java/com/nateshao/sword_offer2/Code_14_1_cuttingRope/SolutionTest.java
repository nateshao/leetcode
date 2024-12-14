package com.nateshao.sword_offer2.Code_14_1_cuttingRope;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 9:32
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 推导
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }

    /**
     * 动态规划
     * dp五部曲:
     * 1.状态定义:dp[i]为长度为i的绳子剪成m段最大乘积为dp[i]
     * 2.状态转移:dp[i]有两种途径可以转移得到
     * 2.1 由前一个dp[j]*(i-j)得到,即前面剪了>=2段,后面再剪一段,此时的乘积个数>=3个
     * 2.2 前面单独成一段,后面剩下的单独成一段,乘积为j*(i-j),乘积个数为2
     * 两种情况中取大的值作为dp[i]的值,同时应该遍历所有j,j∈[1,i-1],取最大值
     * 3.初始化:初始化dp[1]=1即可
     * 4.遍历顺序:显然为正序遍历
     * 5.返回坐标:返回dp[n]
     *
     * @param n
     * @return
     */
    public static int cuttingRope2(int n) {
        // 定义dp数组
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;  // 指长度为1的单独乘积为1
        // 遍历[2,n]的每个状态
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // 求出两种转移情况(乘积个数为2和2以上)的最大值
                int tmp = Math.max(dp[j] * (i - j), j * (i - j));
                dp[i] = Math.max(tmp, dp[i]);
            }
        }
        return dp[n];
    }


}