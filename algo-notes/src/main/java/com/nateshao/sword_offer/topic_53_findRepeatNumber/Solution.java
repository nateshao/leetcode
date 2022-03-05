package com.nateshao.sword_offer.topic_53_findRepeatNumber;

import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2022/3/5 20:21
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 03. 数组中重复的数字
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("findRepeatNumber(nums) = " + findRepeatNumber(nums));
    }

    /**
     * 利用hashset
     * 遍历数组，如果数组中含有相同的数字，说明重复。就直接返回
     * 将num添加到hashset
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }
}
