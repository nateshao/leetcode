package com.nateshao.sword_offer.topic_03_findRepeatNumber;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2022/1/1 16:24
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("findRepeatNumber(arr) = " + findRepeatNumber(arr));
    }

    /**
     * 方法一：哈希表 / Set
     * 利用数据结构特点，容易想到使用哈希表（Set）记录数组的各个数字，当查找到重复数字则直接返回。
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num)) return num;
            dic.add(num);
        }
        return -1;
    }

}
