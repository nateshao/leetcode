package com.nateshao.zijie_code_66;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @date Created by 邵桐杰 on 2022/3/21 10:47
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Day14_merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals,(a,b)->{ // 按区间的 start 升序排列
            return a[0]-b[0];
        });
        res.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = res.getLast();// res 中最后一个元素的引用
            if (curr[0]<=last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            }else {
                res.add(curr); // 处理下一个待合并区间
            }
        }
        return res.toArray(new int[0][0]);

    }
}
