package com.nateshao.sword_offer2.Code_42_maxSubArray;

/**
 * @date Created by 邵桐杰 on 2022/4/16 10:32
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(arr);
        System.out.println("i = " + i);
    }

    /**
     * 动态规划
     * 遍历数组，如果数组中比当前的数字大，就添加进去
     * 1. 定义和 sum=0，res[0];
     * 2. 如果sum>0,相加sum+num,，否则就取num
     * 3. 取数据的最大值res = Math.max(res,sum);
     * 4. return  max;
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, res = nums[0];
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            res = Math.max(res, sum);
        }
        return res;
    }


    // 属于动态规划题
    public int maxSubArray2(int[] nums) {
        // 定义max保存最大值，也就是最终要返回的结果
        int max = Integer.MIN_VALUE;
        //保存连续元素的和
        int sum = 0;
        // 遍历数组
        for (int num : nums) {
            if (sum > 0) sum = sum + num;  // 当连续元素和大于0时，继续相加
            else sum = num; // 当连续元素和小于等于0时，从当前元素重新计算
            // 如果连续和大于最大值，则记录
            max = Math.max(max, sum);
        }
        return max; // 返回最大连续和
    }
}
