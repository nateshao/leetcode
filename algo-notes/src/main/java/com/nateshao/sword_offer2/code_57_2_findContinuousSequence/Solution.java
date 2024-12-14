package com.nateshao.sword_offer2.code_57_2_findContinuousSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/10/3 0:20
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
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
//        int[][] res = new int[list.size()][];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
//        return res;
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 思路，双指针
     * 刚开始 left 在位置 1， right 在位置 2， 定义左右指针之间的数字和为 sum = n*(a1+an)/2
     * 1.类似二分查找的逻辑，当 sum 等于 target 时，将左右指针之间的这种数组加入结果，然后左指针右移
     * 2.当 sum 小于 target 时，右指针右移增大 sum
     * 3.当 sum 大于 target 时，说明以 left 为起点组成的数组不符要求，左指针右移
     * 创建结果数组
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> list = new ArrayList<>();
        int left = 1;
        int right = 2;
        //终止条件是左指针移动到右指针位置，说明此时已经不存在两个数之和能小于 target 了
        while (left < right) {
            int sum = (right - left + 1) * (left + right) / 2;
            if (sum == target) {
                //创建数组存储左右指针之间的数组组合
                int[] tmp = new int[right - left + 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = left + i;
                }
                //将临时数组结果存储入List
                list.add(tmp);
                //继续探索下一种方案
                ++left;
            } else if (sum < target) {
                ++right;
            } else {
                ++left;
            }
        }
        //掌握此种二维list转数组方法
        return list.toArray(new int[list.size()][]);
    }

    public int[][] findContinuousSequence3(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        // 定义左右指针
        int left = 1, right = 2;
        while (left < right) {
            // 左右指针之间的数字和为 sum = n*(a1+an)/2
            int sum = (right - left + 1) * (left + right) / 2;
            if (sum == target) {
                //创建数组存储左右指针之间的数组组合
                int[] temp = new int[right - left + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left + i;
                }
                list.add(temp);
                left++; // 继续探索下一种方案
            } else if (sum < target) right++;
            else left++;
        }
        return list.toArray(new int[list.size()][]);
    }
}