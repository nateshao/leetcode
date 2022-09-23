package com.nateshao.leetcode.code_977_sortedSquares;


import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/9/22 16:54
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] res = sortedSquares(nums);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    /**
     * 把元素 0 作为分界线，0 左侧的负数是一个有序数组 nums1，0 右侧的正数是另一个有序数组 nums2
     * 直接将双指针分别初始化在 nums 的开头和结尾，相当于合并两个从大到小排序的数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1; // 定义左右指针
        int p = nums.length - 1; // 谁大就存放谁，并向前移动。 （得到的有序结果是降序的）
        int[] res = new int[nums.length];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[p] = nums[left] * nums[left];
                left++;
            } else {
                res[p] = nums[right] * nums[right];
                right--;
            }
            p--;
        }
        return res;
    }

    /**
     * 先平方，再排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

//    public static int[] sortedSquares(int[] nums) {
//        int n = nums.length;
//        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
//        int i = 0, j = n - 1;
//        // 得到的有序结果是降序的
//        int p = n - 1;
//        int[] res = new int[n];
//        // 执行双指针合并有序数组的逻辑
//        while (i <= j) {
//            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
//                res[p] = nums[i] * nums[i];
//                i++;
//            } else {
//                res[p] = nums[j] * nums[j];
//                j--;
//            }
//            p--;
//        }
//        return res;
//    }
}
