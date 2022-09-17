package com.nateshao.sword_offer.topic_16_exchange;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/11/22 12:03
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:  调整数组顺序使奇数位于偶数前面
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 7, 6, 8, 10};
        int[] exchange = exchange(nums);
        for (int i : exchange) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] ints = exchange2(nums);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 算法流程：
     *
     * 1. 初始化： i , j 双指针，分别指向数组 nums 左右两端；
     * 2. 循环交换： 当 i = j 时跳出；
     *    1. 指针 i 遇到奇数则执行 i = i + 1 跳过，直到找到偶数；
     *    2. 指针 j 遇到偶数则执行 j = j - 1 跳过，直到找到奇数；
     *    3. 交换 nums[i] 和 nums[j] 值；
     *
     * 3. 返回值：返回已修改的 nums 数组。
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public static int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++; //x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性。
            while (i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

}
