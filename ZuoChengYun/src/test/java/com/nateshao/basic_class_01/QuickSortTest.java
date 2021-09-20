package com.nateshao.basic_class_01;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2021/9/20 10:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    /**
     * @param arr          待排序数组
     * @param indexLeft    // 待排序起始位置
     * @param indexRight// 待排序终点位置
     */
    private static void quickSort(int[] arr, int indexLeft, int indexRight) {
        if (indexLeft > indexRight) {
            return;
        }
        int left = indexLeft;
        int right = indexRight;
        // 待排序的第一个元素作为基准值
        int key = arr[left];

        while (left < right) {
            while (right > left && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, indexLeft, left - 1);
        quickSort(arr, right + 1, indexRight);
    }

}