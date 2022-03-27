package com.nateshao.leetcode_day12_easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2022/3/27 20:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 */
public class Day01_containsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("containsDuplicate(nums) = " + containsDuplicate(nums));
        System.out.println("containsDuplicate2(nums) = " + containsDuplicate2(nums));
        System.out.println("containsDuplicate3(nums) = " + containsDuplicate3(nums));
    }

    // java Set自带去重，如果去重后的长度小于原长度，则返回true
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums) {
            res.add(i);
        }
        return res.size() < nums.length ? true : false;
    }

    /**
     * 方法一：排序
     * 在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。
     * 因此，我们可以扫描已排序的数组，每次判断相邻的两个元素是否相等，如果相等则说明存在重复的元素。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(Nlog N)，其中 N 为数组的长度。需要对数组进行排序。
     * 空间复杂度：O(log N)，其中 N 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums) {
            if (!res.add(i)) return true;
        }
        return false;
    }

}
