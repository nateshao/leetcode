package com.nateshao.basic_class_01;

/**
 * @date Created by 邵桐杰 on 2021/9/13 20:56
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 递归获取最大数
 */
public class GetMaxTest {
    /**
     * 利用递归。获取最大数字
     * 1，递归获取左边的最大数
     * 2，递归获取右边最大数
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) / 2;
        int maxLeft = getMax(arr, L, mid);
        int maxRight = getMax(arr, mid + 1, R);
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 6, 9, 7};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
