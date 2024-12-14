package com.nateshao.sword_offer.topic_44_findContinuousSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/1/25 15:37
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[][] findContinuousSequence = findContinuousSequence(9);
        for (int[] ints : findContinuousSequence) {
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
        }
    }

    /**
     * 解法：滑动窗口（双指针）
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

}
