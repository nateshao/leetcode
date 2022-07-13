package com.nateshao.sword_offer3.day13;

/**
 * @date Created by 邵桐杰 on 2022/7/13 11:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */
public class Day13_twoSum {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 1，初始化： 双指针 i , j 分别指向数组 nums 的左右两端 （俗称对撞双指针）。
     * 2，循环搜索： 当双指针相遇时跳出；
     * 3，计算和 s = nums[i] + nums[j]；
     * 若 s > target ，则指针 j 向左移动，即执行 j = j - 1 ；
     * 若 s < target ，则指针 i 向右移动，即执行 i = i + 1 ；
     * 若 s = target ，立即返回数组 [nums[i], nums[j]] ；
     * 4，返回空数组，代表无和为 target的数字组合。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target)
                i++;
            else if (sum > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
}
