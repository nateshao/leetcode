package com.nateshao.basic_class_01;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2021/9/11 17:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 选择排序，比较次数，哪个数字小，就放在前面
 */
public class Code_01_InsertionSortGetMaxTest {

    @Test
    public void selectionSortTest() {
        int[] arr = {1, 4, 2, 3, 5, 6, 3, 9, 7, 8};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序，小的放在后面
     * 1，如果数组为空，或者数组的值小于2，直接输出（一个数不用排）
     * 2，
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void comparator() {
    }

    @Test
    public void generateRandomArray() {
    }

    @Test
    public void copyArray() {
    }

    @Test
    public void isEqual() {
    }

    @Test
    public void printArray() {
    }

    @Test
    public void main() {
        int[] arr ={1,4,2,5,7,28,9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}