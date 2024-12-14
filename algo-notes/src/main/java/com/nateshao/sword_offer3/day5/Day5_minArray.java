package com.nateshao.sword_offer3.day5;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/5/30 17:32
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * <p>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 */
public class Day5_minArray {
    /**
     * 法一：
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    /**
     * 法二：旋转数组
     *
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (j >= 0 && numbers[i] >= numbers[j]) {
            i = j;
            j--;
        }
        return numbers[i];
    }

    /**
     * 二分查找
     *
     * @param numbers
     * @return
     */
    public int minArray3(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }


}
