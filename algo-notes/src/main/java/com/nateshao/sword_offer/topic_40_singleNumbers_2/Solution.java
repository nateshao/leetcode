package com.nateshao.sword_offer.topic_40_singleNumbers_2;

/**
 * @date Created by 邵桐杰 on 2022/1/18 21:33
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {4, 1, 4, 6};
        System.out.println("singleNumbers(arr) = " + singleNumbers(arr));
    }

    public static int[] singleNumbers(int[] nums) {
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
