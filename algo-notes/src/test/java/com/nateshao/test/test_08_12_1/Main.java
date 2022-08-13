package com.nateshao.test.test_08_12_1;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/8/12 13:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 二分查找算法
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 2;
        int res = Search(arr, target);
        System.out.println(res);
    }

    /** 二分查找
     * @param arr
     * @return
     */
    public static int Search(int[] arr, int target) {
        if (target > arr[arr.length - 1] || target < arr[0]) return -1;
//        if (arr == null) return -1;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
