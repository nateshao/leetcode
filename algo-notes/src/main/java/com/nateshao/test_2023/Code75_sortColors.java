package com.nateshao.test_2023;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2023/2/5 22:48
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode.cn/problems/sort-colors/
 * 75. 颜色分类
 */
public class Code75_sortColors {
//    public void sortColors(int[] nums) {
//         Arrays.sort(nums);
//     }


    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] == 0) {
                swap(i, left++, nums);
            } else if (nums[i] == 2) {
                swap(right--, i--, nums);
            }
        }
    }

    public void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
