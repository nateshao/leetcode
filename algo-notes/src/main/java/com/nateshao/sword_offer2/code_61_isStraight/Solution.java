package com.nateshao.sword_offer2.code_61_isStraight;

import java.util.HashSet;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/10/3 16:54
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Solution {
    /**
     * 根据题意，此 5 张牌是顺子的 充分条件 如下：
     * <p>
     * 除大小王外，所有牌 无重复 ；
     * 设此 5 张牌中最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：
     * max - min < 5
     * <p>
     * 因而，可将问题转化为：此 5 张牌是否满足以上两个条件？
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public boolean isStraight2(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (res.contains(num)) return false;
            res.add(num);
        }
        return max - min < 5;
    }
}
