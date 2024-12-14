package com.nateshao.sword_offer3.day13;

/**
 * @date Created by 邵桐杰 on 2022/7/13 11:25
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Day13_exchange {
    /**
     * 双指针
     * 考虑定义双指针 i , j 分列数组左右两端，循环执行：
     *
     * 指针 i 从左向右寻找偶数；
     * 指针 j 从右向左寻找奇数；
     * 将 偶数 nums[i]和 奇数 nums[j]交换。
     * 可始终保证： 指针 i 左边都是奇数，指针 j 右边都是偶数 。
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++; //x&1位运算等价于 x %2取余运算，即皆可用于判断数字奇偶性。
            while (i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}














