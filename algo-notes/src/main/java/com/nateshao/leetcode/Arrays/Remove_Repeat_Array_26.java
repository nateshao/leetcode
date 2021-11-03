package com.nateshao.leetcode.Arrays;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/11/3 15:11
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 删除有序数组的重复项
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * <p>
 * 思路：
 * 我把本题归结为快慢指针的问题，慢指针是指向所有不重复的元素，快指针指的是所有的元素，
 * 当数组中没有重复元素的时候，他们是相同的，指针的话我一般喜欢用while循环，
 * 自己控制指针在什么情况下才自增。
 */
public class Remove_Repeat_Array_26 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 2, 3, 4, 5, 76, 89, 22};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}