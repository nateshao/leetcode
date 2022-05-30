package com.nateshao.sword_offer3.day5;

/**
 * @date Created by 邵桐杰 on 2022/5/30 12:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class Day5_findNumberIn2DArray {
    /**
     * 二分查找
     * 只能左下角或者是右上角进行查找
     * 1.左下角开始查找，如果小于target,就向上查找，如果是大于就向右查找。
     * 2.右上角开始查找，如果是小于target就向下，大于就向左查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = matrix.length - 1, y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] > target) x--;
            else if (matrix[x][y] < target) y++;
            else return true;
        }
        return false;
    }
}
