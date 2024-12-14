package com.nateshao.albaba_03_14;

/**
 * @date Created by 邵桐杰 on 2022/4/28 22:21
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Leetcode905 {
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
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) left++;
            while (left < right && nums[right] % 2 == 1) right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
