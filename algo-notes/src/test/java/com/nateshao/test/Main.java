package com.nateshao.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/8/15 11:31
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Main {


    /**
     * 输入一个字符串，如"123.456"
     * 100.0
     * 0
     * 0.003
     * 返回浮点数，123.456
     * <p>
     * 精度误差不能超过一半，尽可能小
     */
    public float stringToFloat(String s) {
        ArrayList<Integer> list1 = new ArrayList<>();
        int baiwei = 0;
        int[] arr = {1, 2, 3};
        for (int i : arr) {
            if (arr[i] == 1) {

            }
        }

//        System.out.println(arr.toString());
        //
        ArrayList<Float> list = new ArrayList<>();
//        Float res = new Float();
//        for (Float aFloat : list) {
//            res  = list.get(aFloat);
//        }
        return Float.MIN_VALUE;
    }
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) return;
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, leftIndex, left - 1);
        quickSort(arr, right + 1, rightIndex);

    }


}
