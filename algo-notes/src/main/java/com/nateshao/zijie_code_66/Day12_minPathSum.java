package com.nateshao.zijie_code_66;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/3/19 22:46
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/minimum-path-sum/
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class Day12_minPathSum {
    /**
     * labuladong
     * 基本思路
     * 一般来说，让你在二维矩阵中求最优化问题（最大值或者最小值），肯定需要递归 + 备忘录，也就是动态规划技巧。
     * <p>
     * dp 函数的定义：从左上角位置 (0, 0) 走到位置 (i, j) 的最小路径和为 dp(grid, i, j)。
     * 这样，dp(grid, i, j) 的值由 dp(grid, i - 1, j) 和 dp(grid, i, j - 1) 的值转移而来：
     *
     * @param grid
     * @return
     */
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;// 左上角
        // 构造备忘录。初始值为-1
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    private int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 将计算结果记住备忘录
        memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
        return memo[i][j];
    }


}
