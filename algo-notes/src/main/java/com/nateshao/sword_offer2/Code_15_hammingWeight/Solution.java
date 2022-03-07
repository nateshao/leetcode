package com.nateshao.sword_offer2.Code_15_hammingWeight;

/**
 * @date Created by 邵桐杰 on 2022/3/7 19:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("hammingWeight(11) = " + hammingWeight(11));
        System.out.println("hammingWeight2(11) = " + hammingWeight2(11));
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;

//        return Integer.bitCount(n);
    }

    public static int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }
}
