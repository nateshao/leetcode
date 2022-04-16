package com.nateshao.sword_offer2.Code_41_maxSubArray;

/**
 * @date Created by 邵桐杰 on 2022/4/16 10:32
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 动态规划
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i] + dp[i - 1], dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * k神
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

}
