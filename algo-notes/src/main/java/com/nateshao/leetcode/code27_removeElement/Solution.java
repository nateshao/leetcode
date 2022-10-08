package com.nateshao.leetcode.code27_removeElement;

/**
 * @date Created by 邵桐杰 on 2022/10/7 22:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/remove-element/
 * 27. 移除元素
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        // 第一快指针
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
