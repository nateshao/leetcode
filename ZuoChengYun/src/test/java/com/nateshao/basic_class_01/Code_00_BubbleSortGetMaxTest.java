package com.nateshao.basic_class_01;

import org.junit.Test;
import java.util.Arrays;
/**
 * @date Created by 邵桐杰 on 2021/9/11 16:35
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Code_00_BubbleSortGetMaxTest {

    @Test
    public void bubbleSortTest() {
        int[] arr = {1, 9, 4, 8, 2, 6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void swapTest() {
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


    /** 冒泡排序，两两交换，如果a[i]>a[i+1],a[i]放在后面
     * 1，如果数组为空，或者数组的值小于2，直接输出（一个数不用排）
     * 2，
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) { // 比较趟数 ：一开始是end,然后end-1
            for (int i = 0; i < end; i++) { // 数组长度
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 两数交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}