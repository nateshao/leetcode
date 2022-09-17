package com.nateshao.sword_offer.topic_03_find_array;

import org.junit.Test;

/**
 * @date Created by 邵桐杰 on 2021/11/9 23:31
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 面试题3: 二维数组中的查找
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：从右上角或左下角开始找，逐行排除，或者用二分法查找
 * 解法一：双指针，时间复杂度：O(mn)，空间复杂度：O(1)
 */
public class FindArray {

    /**
     * 解法一 ：暴力
     * 时间复杂度：O(nm)。二维数组中的每个元素都被遍历，因此时间复杂度为二维数组的大小。
     * 空间复杂度：O(1)。
     * 如果不考虑二维数组排好序的特点，则直接遍历整个二维数组的每一个元素，判断目标值是否在二维数组中存在。
     *
     * 依次遍历二维数组的每一行和每一列。如果找到一个元素等于目标值，则返回 true。
     * 如果遍历完毕仍未找到等于目标值的元素，则返回 false。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }



    /**
     * 解法二：线性查找
     * 时间复杂度 O(M+N) ：其中，N 和 M 分别为矩阵行数和列数，此算法最多循环 M+N次。
     * 空间复杂度 O(1)：x, y 指针使用常数大小额外空间。
     * 参考链接：https://zhuanlan.zhihu.com/p/210111553
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            } else if (num > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;

//        int i = matrix.length - 1, j = 0;
//        while (i >= 0 && j < matrix[0].length) {
//            if (matrix[i][j] > target) i--;
//            else if (matrix[i][j] < target) j++;
//            else return true;
//        }
//        return false;

    }


    @Test
    public void testfindNumberIn2DArray() {
        int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 8;
        boolean numberIn2DArray = findNumberIn2DArray2(arr, target);
        System.out.println(numberIn2DArray);
    }
}
