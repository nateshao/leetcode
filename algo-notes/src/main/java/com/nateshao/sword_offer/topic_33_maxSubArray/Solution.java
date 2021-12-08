package com.nateshao.sword_offer.topic_33_maxSubArray;

/**
 * @date Created by 邵桐杰 on 2021/12/8 18:35
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 42. 连续子数组的最大和
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int arr = maxSubArray(nums);
        System.out.println("arr = " + arr); // arr = 6
    }

    /**
     * 思路：若和小于 0，则将最大和置为当前值，否则计算最大和。
     * 代码实现：时间复杂度：O(n)，空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int result = nums[0];
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            result = Math.max(sum, result);
        }
        return result;
    }
}
