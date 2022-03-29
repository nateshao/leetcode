package com.nateshao.sword_offer2.Code_03_findRepeatNumber;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2022/3/5 21:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int number = findRepeatNumber(nums);
        System.out.println("number = " + number);
    }

    /**
     * 用hashset
     * 遍历数组，如果数组中有相同的话，说明重复直接返回。
     * 将不重复的添加到hashset
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    /**
     * 先排序
     * 如果前一位与后一位相等，说明重复，直接返回nums[i]
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }

}
