package com.nateshao.sword_offer2.Code_21_exchange;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 15:15
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class SolutionTest {
    /**
     * 一次遍历，简单交换位置
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[a];
                nums[a] = temp;
                a++;
            }
        }
        return nums;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int num : nums) {
            if ((num & 1) == 0) {
                res[right--] = num;
            } else {
                res[left++] = num;
            }
        }
        return res;
    }

    /**
     * 双指针
     * 常规
     * @param nums
     * @return
     */
    public int[] exchange3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}