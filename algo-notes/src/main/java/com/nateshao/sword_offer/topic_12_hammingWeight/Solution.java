package com.nateshao.sword_offer.topic_12_hammingWeight;

/**
 * @date Created by 邵桐杰 on 2021/11/20 12:03
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 二进制中1的个数
 */
public class Solution {

    public static void main(String[] args) {
        int hammingWeight = hammingWeight(11);
        System.out.println("hammingWeight = " + hammingWeight);
        int hammingWeight2 = hammingWeight2(11);
        System.out.println("hammingWeight2 = " + hammingWeight2);
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
