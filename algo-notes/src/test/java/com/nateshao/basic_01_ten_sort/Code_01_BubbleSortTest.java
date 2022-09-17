package com.nateshao.basic_01_ten_sort;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/10/29 16:52
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 原文链接 https://zfhelo.gitee.io/2020/06/14/1/
 */
public class Code_01_BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        boolean isSwap;
        // 外层循环控制比较的轮数
        for (int i = 0; i < arr.length - 1; i++) {
            isSwap = false;
            // 内层循环进行相邻元素比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { // 前面的数比后面的数大则交换
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }

            if (!isSwap) {
                return; // 代码优化，如果一轮循环中没有进行交换元素则说明数组已经是有序的了
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}