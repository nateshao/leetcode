package com.nateshao.sword_offer3.day9;

/**
 * @date Created by 邵桐杰 on 2022/7/10 12:11
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Day9_maxSubArray {
    /**
     * 这题类似 最长递增子序列，dp 数组的含义：
     * 以 nums[i] 为结尾的「最大子数组和」为 dp[i]。
     * dp[i] 有两种「选择」，要么与前面的相邻子数组连接，形成一个和更大的子数组；
     * 要么不与前面的子数组连接，自成一派，自己作为一个子数组。
     * <p>
     * 在这两种选择中择优，就可以计算出最大子数组，而且空间复杂度还有优化空间，见详细题解。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int[] dp = new int[nums.length + 1];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * 动态规划
     * 通俗易懂
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            res = Math.max(res, sum);
        }
        return res;
    }


}
