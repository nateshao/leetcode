package com.nateshao.sword_offer2.Code_53_2_missingNumber;

/**
 * @date Created by 邵桐杰 on 2022/10/2 19:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Solution {
    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    /**
     * 只要比较数组下标和该下标对应的值即可，再排除缺失0和缺失最后一项两个特殊情况。
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        if (nums[0] == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
}
