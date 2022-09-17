package com.nateshao.basic_01_ten_sort;

/**
 * @date Created by 邵桐杰 on 2021/10/29 22:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 选择排序
 */
public class Code_03_SelectionSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i; // 默认当前排序数组的第一个元素为最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) { // 发现一个更小的，更小最小值索引
                    min = j;
                }
            }

            if (i != min) {
                swap(arr, i, min);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}