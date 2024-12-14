package com.nateshao.sword_offer2.Code_04_findNumberIn2DArray;

/**
 * @date Created by 邵桐杰 on 2022/3/5 21:23
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class Solution {
    /**
     * 个人理解，也就是说从（i,j）左下脚开始找，
     * 如果比目标值小，向上找，i--
     * 如果比目标值大，向右找，j++
     * 最后找到了，return true
     * 否则 return false
     * <p>
     * 二分法
     * 从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
     * 当 matrix[i][j] > target 时，执行 i-- ，即消去第 i 行元素；
     * 当 matrix[i][j] < target 时，执行 j++ ，即消去第 j 列元素；
     * 当 matrix[i][j] = target 时，返回 true ，代表找到目标值。
     * 若行索引或列索引越界，则代表矩阵中无目标值，返回 false 。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;// i,j = x,y
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i > 0 && j <= matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            return true;
        }
        return false;

    }

}
