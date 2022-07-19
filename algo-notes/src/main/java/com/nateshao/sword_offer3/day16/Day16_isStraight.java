package com.nateshao.sword_offer3.day16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/7/18 23:52
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day16_isStraight {
    /**
     * 方法一： 集合 Set + 遍历
     * 遍历五张牌，遇到大小王（即 0 ）直接跳过。
     * 判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为O(1) ；
     * 获取最大 / 最小的牌： 借助辅助变量 ma 和 mi ，遍历统计即可。
     * 复杂度分析：
     * 时间复杂度 O(N) = O(5) = O(1) ： 其中 NN 为 nums 长度，本题中 N≡5 ；遍历数组使用 O(N) 时间。
     * 空间复杂度 O(N) = O(5) = O(1)： 用于判重的辅助 Set 使用 O(N) 额外空间。
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
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





    /**
     * 方法二：先排序 + 遍历
     * 1，数组排序
     * 2，定义大王 int joker = 0;
     * 3，循环遍历数组4
     *  统计大小王的数量：如果nums[i]==0， joker++;
     *  如果有重复，返回false：nums[i] == nums[i + 1]
     *  返回顺子：nums[4] - nums[joker] < 5;
     * @param nums
     * @return
     */
    public boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
