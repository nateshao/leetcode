package com.nateshao.basic_class_01;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2021/9/20 10:06
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9, 6, 87, 3, 21, 54, 23, 76, 99};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.printf(i + "\t");
        }
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