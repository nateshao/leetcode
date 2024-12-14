package com.nateshao.top;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2022/2/23 21:50
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: Java实现递归与非递归的快速排序
 */
public class Top_01_QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        /**
         * 如果左边大于右边，直接返回
         */
        if (leftIndex >= rightIndex) return;

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }


    /**
     * 非递归（使用LinkedHashMap）
     *
     * @param s
     * @param left
     * @param right
     */
    void quickSort1(int s[], int left, int right) {
        LinkedHashMap<Integer, Integer> lhp = new LinkedHashMap<>();
        //将0,n放入LinkedHashMap
        lhp.put(left, right);
        while (!lhp.isEmpty()) {      //只要有需要排序的段
            //读取left，right
            Iterator<Map.Entry<Integer, Integer>> it = lhp.entrySet().iterator();
            left = it.next().getKey();
            right = lhp.get(left);
            //并从LinkedHashMap中删除
            lhp.remove(left, right);
            if (left >= right) continue;
            int i = left, j = right, temp = s[right];
            while (i < j) {         //遍历排序一遍
                while (s[i] <= temp && i < j) i++;
                if (i < j) s[j--] = s[i];
                while (s[j] >= temp && i < j) j--;
                if (i < j) s[i++] = s[j];
            }
            s[i] = temp;
            lhp.put(left, i - 1);
            lhp.put(i + 1, right);
        }

    }


    /**
     * 1.如果left>right return null
     * 2.以左边第一个为基准值
     * 从右向左遍历，如果右边的值比左边小，就放到左边
     * 从左向右遍历，如果左边的值比右边大，就放到右边，
     * 循环递归
     *
     * @param arr
     * @param leftIndex
     * @param rightIndex
     */
    static void quickSort2(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;
        int left = leftIndex;
        int right = rightIndex;
        // 初始化基准值
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
        quickSort2(arr, leftIndex, left - 1);
        quickSort2(arr, right + 1, rightIndex);

    }
}
