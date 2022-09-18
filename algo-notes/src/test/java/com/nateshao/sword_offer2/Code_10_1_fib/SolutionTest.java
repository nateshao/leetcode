package com.nateshao.sword_offer2.Code_10_1_fib;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/18 13:52
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i]%=1000000007;
        }
        return dp[n];
    }

}