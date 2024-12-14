package com.nateshao.zijie_code_66;

import java.util.LinkedList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/3/16 9:25
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/spiral-matrix/
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Day06_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> order = spiralOrder(matrix);
        order.stream().forEach(res-> System.out.print(" " + res));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new LinkedList<>();
        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;
        List<Integer> list = new LinkedList<>();
        while (l <= r && u <= d) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[u][i]);
            }
            u++;
            for (int i = u; i <= d; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && u <= d; i--) {
                list.add(matrix[d][i]);
            }
            d--;
            for (int i = d; i >= u && l <= r; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }

}
