package com.nateshao.basic_01_ten_sort;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/10/30 10:44
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 希尔排序
 */
public class Code_03_ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        shellSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */
    public static void shellSort1(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];

    }

//    public static void shellSort(int[] arr) {
//        int interval = arr.length / 2; // 默认间隔
//
//        while (interval >= 1) {
//            for (int i = interval; i < arr.length - 1; i++) {
//                int preIndex = i - interval;
//                int temp = arr[i];
//
//                if (temp < arr[preIndex]) {
//                    while (preIndex >= 0 && temp < arr[preIndex]) {
//                        arr[preIndex + interval] = arr[preIndex];
//                        preIndex -= interval;
//                    }
//                    arr[preIndex + interval] = temp;
//                }
//            }
//            interval = interval / 2; // 缩小间隔
//        }
//    }
}
