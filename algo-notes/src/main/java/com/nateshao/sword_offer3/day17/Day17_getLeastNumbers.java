package com.nateshao.sword_offer3.day17;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/7/19 21:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day17_getLeastNumbers {
    /**
     * 排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
        /**
         * Arrays.sort(arr);
         * return Arrays.copyOf(arr,k);
         */
    }

    /**
     * 快排
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k > arr.length) return arr;
    }
}
