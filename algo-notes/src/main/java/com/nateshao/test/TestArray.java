package com.nateshao.test;

import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;
import java.util.Objects;

/**
 * @date Created by 邵桐杰 on 2022/5/9 12:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class TestArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
//        int start = 0;
//        int end = arr2.length - 1;
//        while (start <= end) {
//            int temp = arr2[start];
//            arr2[start] = arr2[end];
//            arr2[end] = temp;
//            start++;
//            end--;
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.print(arr2[i] + " ");
//        }
//        int[] res = sort1(arr1);
        int[] res = sort2(arr1);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println("----------------------");
        System.out.println();
        int[] res1 = sort2(arr1);
        for (int i : res1) {
            System.out.print(i+" ");
        }
    }


    public static int[] sort1(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
//           int temp = arr[right];
//            arr[right] = arr[left];
//            arr[left] = temp;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public static int[] sort2(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}
