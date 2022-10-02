package com.nateshao.sword_offer2.Code_53_search;

/**
 * @date Created by 邵桐杰 on 2022/10/2 18:38
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class Solution {
    /**
     * 二分法
     * 结果 ： right -  left + 1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
//            int mid = left+(right-left)/2; // 在i和j特别大的情况下，可能会发生整形溢出的风险，所以最好的写法是
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else {
                if (nums[left] == nums[right]) return right - left + 1;
                else if (nums[left] != target) left++;
                else if (nums[right] != target) right--;
            }
        }
        return 0;
    }

    public int search2(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) res++;
        }
        return res;
    }


    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid-1;
            if (nums[mid] < target)
                left = mid + 1;
        }
        while (left < nums.length && nums[left++] == target)
            count++;
        return count;
    }

//    public int[] searchRange(int[] nums, int target) {
//
//    }
}
