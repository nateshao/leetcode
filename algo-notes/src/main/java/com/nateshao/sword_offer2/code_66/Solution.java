package com.nateshao.sword_offer2.code_66;

/**
 * @date Created by 邵桐杰 on 2022/8/20 19:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 定义结果集：
     * <p>
     * 1. 从左往右累乘
     * 2. 从右往左累乘
     * 3. 返回结果集
     *
     * @param nums
     * @return
     */
    public int[] constructArr(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, cur = 1; i < nums.length; i++) { // 从左往右累乘
            res[i] = cur;
            cur *= nums[i];
        }
        for (int i = nums.length - 1, cur = 1; i >= 0; i--) { // 从右往左累乘
            res[i] *= cur;
            cur *= nums[i];
        }
        return res;
    }
}
