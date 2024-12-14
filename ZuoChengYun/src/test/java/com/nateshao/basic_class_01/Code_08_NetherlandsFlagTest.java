package com.nateshao.basic_class_01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2021/9/18 20:03
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 荷兰国旗问题
 */
public class Code_08_NetherlandsFlagTest {

    public static int[] partition(int[] arr, int l, int r, int num) {

        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();
        printArray(test);

        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(res);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}