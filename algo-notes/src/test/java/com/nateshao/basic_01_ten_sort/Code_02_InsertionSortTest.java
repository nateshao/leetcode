package com.nateshao.basic_01_ten_sort;

/**
 * @date Created by 邵桐杰 on 2021/10/29 21:56
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 插入排序
 */
public class Code_02_InsertionSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static void insertionSort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            // 比前面的数小
//            if (arr[i] < arr[i - 1]) {
//                int temp = arr[i]; // 将这个值保存起来
//                int j = i;
//                // 往前找 直到找到一个小于这个数的值
//                do {
//                    arr[j] = arr[j - 1];
//                    j--;
//                } while (j >= 0 && arr[j] > temp);
//
//                arr[j + 1] = temp; // 把这个数放在寻找到的数的后面
//            }
//        }
//    }
}