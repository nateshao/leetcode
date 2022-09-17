package com.nateshao.basic_01_ten_sort;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/10/30 16:14
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Code_10_HeapSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] nums) {
        build(nums); // 将数组构建成堆
        for (int i = nums.length - 1; i >= 0; i--) {
            // 根节点为此时是最大值，将其放在最后一个位置
            swap(nums, 0, i);
            // 缩小数组 将数组再次构建成堆
            heapify(nums, i, 0);
        }
    }

    /**
     * 调整堆
     * @param tree
     * @param n
     * @param p
     */
    private static void heapify(int[] tree, int n, int p) {
        int l = p * 2 + 1; // 左孩子
        int r = p * 2 + 2; // 有孩子
        int max = p;
        if (l < n && tree[max] < tree[l]) {
            max = l;
        }
        if (r < n && tree[max] < tree[r]) {
            max = r;
        }
        if (max != p) {
            swap(tree, p, max);
            heapify(tree, n, max); // 被交换的节点可能会影响到子节点
        }
    }

    /**
     * 将数组构建堆
     * @param tree
     */
    private static void build(int[] tree) {
        // 从最后一个 parent 开始构建堆
        for (int p = (tree.length - 2) / 2; p >= 0; p--) {
            heapify(tree, tree.length, p);
        }
    }

    // 交换
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}