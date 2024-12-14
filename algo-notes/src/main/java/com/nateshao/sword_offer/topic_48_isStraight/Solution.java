package com.nateshao.sword_offer.topic_48_isStraight;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/2/21 22:45
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println("isStraight(nums) = " + isStraight(nums));
        System.out.println("isStraight2(nums) = " + isStraight2(nums));
    }
    /**
     * 先对数组执行排序。
     * 判别重复： 排序数组中的相同元素位置相邻，因此可通过遍历数组，判断 nums[i] = nums[i + 1]nums[i]=nums[i+1] 是否成立来判重。
     * 获取最大 / 最小的牌： 排序后，数组末位元素 nums[4]nums[4] 为最大牌；元素 nums[joker]nums[joker] 为最小牌，其中 jokerjoker 为大小王的数量。
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i]==0)joker++;//统计大小王的数量
            else if(nums[i]==nums[i+1])return false;//重复就返回false
        }
        return nums[4]-nums[joker]<5;//最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static boolean isStraight2(int[] nums) {

        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子

    }
}
