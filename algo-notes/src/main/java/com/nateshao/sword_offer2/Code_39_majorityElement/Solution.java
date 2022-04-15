package com.nateshao.sword_offer2.Code_39_majorityElement;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/4/15 22:14
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class Solution {
    /**
     * 需要的数字出现次数多于一半 那么排序后必定在中间
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 思路：将首次出现的数 count+1，与之后的数进行比较，相等则+1，否则—1，
     * 最后进行校验是否超过长度的一半。
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return checkMoreThanHalf(nums, candidate) ? candidate : 0;
    }

    private static boolean checkMoreThanHalf(int[] array, int number) {
        int times = 0;
        for (int i : array) {
            if (i == number) times++;
        }
        return times * 2 >= array.length;
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        //摩尔投票
        int count = 0;
        Integer card = null;
        for (int num : nums) {
            if (count == 0) card = num;
            count += (card == num) ? 1 : -1;
        }
        return card;
    }
}
