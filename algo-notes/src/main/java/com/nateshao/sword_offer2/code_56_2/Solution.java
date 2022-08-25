package com.nateshao.sword_offer2.code_56_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @date Created by 邵桐杰 on 2022/8/21 21:01
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class Solution {
    /**
     * hashmap
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer a = map.getOrDefault(nums[i], 0);
            map.put(nums[i], a + 1);
        }
        for (Integer a : map.keySet()) {
            if (map.get(a) == 1) return a;
        }
        return -1;
    }


    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
//    public int singleNumber3(int[] nums) {
//        int left = 0;
//        int right = nums.length-1;
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//        while (nums[left]<nums[right]){
//
//        }
//    }

}















