package com.nateshao.sword_offer2.Code_04_findNumberIn2DArray;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/17 22:57
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 二分查找
     * 从左下角开始往上面
     * 在i>=0和j<matrix[0].length的条件下
     * 如果大于target的话，就往上移动i--，
     * 如果小于target的话，就往有移动j++。
     * 找到就返回true
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;//(i,j) = (x,y)
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;// while 循环中没有找到，则 target 不存在
    }
}