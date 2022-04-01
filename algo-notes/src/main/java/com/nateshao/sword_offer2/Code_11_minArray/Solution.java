package com.nateshao.sword_offer2.Code_11_minArray;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/3/6 21:45
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Solution {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println("minArray(numbers) = " + minArray(numbers));
        System.out.println("-------------");
        Arrays.sort(numbers);
        System.out.println(numbers[0]);
    }

    /**
     * 二分查找
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) left = mid + 1;
            else if (numbers[mid] < numbers[right]) right = mid;
            else right--;
        }
        return numbers[left];
    }

    /**
     * 思路2，
     * 1，先排序
     * 2，返回数组第一个元素
     * @param numbers
     * @return
     */
    public static int minArray2(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
