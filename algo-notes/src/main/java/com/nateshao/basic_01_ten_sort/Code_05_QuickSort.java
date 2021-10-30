package com.nateshao.basic_01_ten_sort;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/10/30 12:09
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 快速排序
 */
public class Code_05_QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int indexLeft, int indexRight) {
        if (indexLeft >= indexRight) {
            return;
        }
        int left = indexLeft;
        int right = indexRight;
        int key = arr[left];
        while (left < right) {
            // 右边
            while (right > left && arr[right] > key) {
                right--;
            }
            arr[left] = arr[right];
            // 左边
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }

        // 基准归位
        arr[left] = key;
        quickSort(arr, indexLeft, left - 1);
        quickSort(arr, right + 1, indexRight);
    }
}
