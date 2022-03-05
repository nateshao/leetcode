package com.nateshao.interview.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/3/4 9:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 看域构建多少种树
 * 小强现在有个节点,他想请你帮他计算出有多少种不同的二叉树满足节点个数为且树的高度不超过的方案.因为答案很大,所以答案需要模上1e9+7后输出.
 * 树的高度: 定义为所有叶子到根路径上节点个数的最大值.
 * 例如: 当n=3,m=3时,有如下5种方案:
 */
public class Erchashu {
    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);33
        int n = in.nextInt();
        int m = in.nextInt();
        // dp[i][j]表示i个节点最大深度为j的树数量
        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    // 左子树节点数为k，右子树节点数为i-k-1，且左右子树都要求小于等于j-1
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * dp[i - k - 1][j - 1] % MOD) % MOD;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
