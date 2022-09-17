package com.nateshao.basic_01_ten_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @date Created by 邵桐杰 on 2021/10/30 15:56
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 桶排序
 */
public class Code_09_BucketSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int bucketNum = (max - min) / 10 + 1; // 桶的数量
        List[] buckets = new ArrayList[bucketNum];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // 把元素装入桶中
        for (int i = 0; i < arr.length; i++) {
            int a = (arr[i] - min) / 10;
            buckets[a].add(arr[i]);
        }

        int index = 0;
        for (List<Integer> b : buckets) {
            insertionSort(b); // 排序桶内元素
            for (Integer num : b) {
                arr[index++] = num; // 取出排序好的元素
            }
        }
    }

    // 插入排序
    public static void insertionSort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            // 从第二个开始查看是否比前一个小
            if (arr.get(i) < arr.get(i - 1)) {
                // 逐个往前找如果大于此数则将其往后移动一位
                int temp = arr.get(i);
                int j = i - 1;
                while (j >= 0 && temp < arr.get(j)) {
                    arr.set(j + 1, arr.get(j));
                    j--;
                }
                // 找到一个比它小的数----将其赋值给此数后面的元素
                arr.set(j + 1, temp);
            }
        }
    }
}