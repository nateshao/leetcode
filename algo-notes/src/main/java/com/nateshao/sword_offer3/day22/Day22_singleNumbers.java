package com.nateshao.sword_offer3.day22;

/**
 * @date Created by 邵桐杰 on 2022/7/23 9:47
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class Day22_singleNumbers {
    /**
     * 拆分 nums 为两个子数组
     * 相同的数异或为0，不同的异或为1。0和任何数异或等于这个数本身。
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums)               // 1. 遍历异或
            n ^= num;
        while ((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for (int num : nums) {              // 3. 遍历 nums 分组
            if ((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[]{x, y};          // 5. 返回出现一次的数字
    }
}
