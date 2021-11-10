package com.nateshao.sword_offer.topic_02_find_array;

/**
 * @date Created by 邵桐杰 on 2021/11/9 23:31
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 面试题3: 二维数组中的查找
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列
 * 都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：从右上角或左下角开始找，逐行排除，或者用二分法查找
 * 解法一：双指针，时间复杂度：O(mn)，空间复杂度：O(1)
 */
public class FindArray {
    /**
     * 解法一：双指针，时间复杂度：O(mn)，空间复杂度：O(1)
     *
     * @param arr
     * @param target
     * @return
     */
    public static boolean findarray1(int[][] arr, int target) {
        if (arr == null || arr.length == 0) return false;

        int row = 0;
        int column = arr[0].length - 1;
        while (row < arr.length && column >= 0) {
            if (arr[row][column] == target) return true;
            if (arr[row][column] > target) {
                column++;
            } else {
                row--;
            }
        }
        return false;
    }

    /**
     * 解法二：二分法，时间复杂度：O(log mn)，空间复杂度：O(1)
     *
     * @param arr
     * @param target
     * @return
     */
    public static boolean findarray2(int[][] arr, int target) {
        if (arr == null || arr.length == 0) return false;

        int left = 0;
        int right = arr.length * arr[0].length - 1;
        int col = arr[0].length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = arr[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
