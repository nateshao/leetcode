package com.nateshao.sword_offer2.code_57_2_findContinuousSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/10/3 0:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        //🧠里要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
        //套滑动窗口模板，left是窗口左边界，right是窗口右边界，窗口中的值一定是连续值。
        //当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
        for (int left = 1, right = 1, sum = 0; right < target; right++) {
            sum += right;
            while (sum > target) {
                sum -= left++;
            }
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left + i;
                }
                list.add(temp);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}