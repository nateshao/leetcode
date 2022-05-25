package com.nateshao.test;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/5/24 22:19
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 合并两个有序数组
 */
public class MergeArr {
    /**
     * 归并排序
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a1 = {45, 56, 78, 82};
        int[] a2 = {32, 48, 72, 79, 83, 85, 92};
        // 利用新的数组存储两个合并后的数组
        int[] res = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        // 如果谁小将谁复制到合并后的数组
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                res[k++] = a1[i];
                i++;
            } else {
                res[k++] = a2[j];
                j++;
            }
        }
        while (i < a1.length) {
            res[k++] = a1[i];
            i++;
        }
        while (j < a2.length) {
            res[k++] = a2[j];
            j++;
        }
        System.out.print("数组合并后：" + Arrays.toString(res));
    }

}
