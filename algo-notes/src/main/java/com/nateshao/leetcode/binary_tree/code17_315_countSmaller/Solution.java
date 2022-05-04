package com.nateshao.leetcode.binary_tree.code17_315_countSmaller;

import java.util.LinkedList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/5/4 11:36
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 315. 计算右侧小于当前元素的个数
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质：
 * counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 *
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 */
class Solution {
    private class Pair {
        int val, id;

        Pair(int val, int id) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.id = id;
        }
    }

    // 归并排序所用的辅助数组
    private Pair[] temp;
    // 记录每个元素后面比自己小的元素个数
    private int[] count;

    // 主函数
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];
        Pair[] arr = new Pair[n];
        // 记录元素原始的索引位置，以便在 count 数组中更新结果
        for (int i = 0; i < n; i++)
            arr[i] = new Pair(nums[i], i);

        // 执行归并排序，本题结果被记录在 count 数组中
        sort(arr, 0, n - 1);

        List<Integer> res = new LinkedList<>();
        for (int c : count) res.add(c);
        return res;
    }

    // 归并排序
    private void sort(Pair[] arr, int lo, int hi) {
        if (lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    // 合并两个有序数组
    private void merge(Pair[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                arr[p] = temp[j++];
            } else if (j == hi + 1) {
                arr[p] = temp[i++];
                // 更新 count 数组
                count[arr[p].id] += j - mid - 1;
            } else if (temp[i].val > temp[j].val) {
                arr[p] = temp[j++];
            } else {
                arr[p] = temp[i++];
                // 更新 count 数组
                count[arr[p].id] += j - mid - 1;
            }
        }
    }
}
