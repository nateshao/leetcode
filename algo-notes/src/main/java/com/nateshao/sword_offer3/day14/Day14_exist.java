package com.nateshao.sword_offer3.day14;

/**
 * @date Created by 邵桐杰 on 2022/7/16 22:37
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class Day14_exist {

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) return false;
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;

    }

    /**
     * 深度优先遍历
     *
     * @param board
     * @param words
     * @param i
     * @param j
     * @param k
     * @return
     */
    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) return false;
        if (k == words.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, k + 1) ||
                      dfs(board, words, i - 1, j, k + 1) ||
                      dfs(board, words, i, j + 1, k + 1) ||
                      dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}
