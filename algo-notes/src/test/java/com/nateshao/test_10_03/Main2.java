package com.nateshao.test_10_03;

/**
 * @date Created by 邵桐杰 on 2022/10/3 23:54
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Main2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    public int minPathSum (int[][] grid) {
        // write code here
        if (grid==null||grid.length==0||grid[0].length==0)return 0;

       int rows = grid.length,clums = grid[0].length;
        int[][] dp = new int[rows][clums];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < clums; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < clums; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][clums-1];

    }
}
