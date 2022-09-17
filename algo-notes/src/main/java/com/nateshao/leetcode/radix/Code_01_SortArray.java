package com.nateshao.leetcode.radix;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/10/30 22:33
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 912. 排序数组
 * 原文链接：https://leetcode-cn.com/problems/sort-an-array/
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class Code_01_SortArray {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int rt = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (rt < nums[j]) {
                    nums[j + 1] = nums[j];
                    nums[j] = rt;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    // int min;
    // for(int i = 0;i<nums.length;i++){
    //     min = i;
    //     for(int j = i;j<nums.length;j++){
    //         if(nums[j] < nums[min]){
    //             min = j;
    //         }
    //     }
    //     if(min != i) {
    //         int temp = nums[i];
    //         nums[i] = nums[min];
    //         nums[min] = temp;
    //     }
    // }
    // return nums;
}
