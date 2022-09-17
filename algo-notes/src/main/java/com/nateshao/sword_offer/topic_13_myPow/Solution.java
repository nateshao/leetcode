package com.nateshao.sword_offer.topic_13_myPow;

/**
 * @date Created by 邵桐杰 on 2021/11/21 10:48
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:  剑指 Offer 16. 数值的整数次方 难度：中等
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class Solution {
    public static void main(String[] args) {
        double v = myPow1(2, 3);
        double v2 = myPow1(2, 3);
        System.out.println("v = " + v);
        System.out.println("v2 = " + v2);
    }

    public static double myPow1(double x, int n) {
        if (n == 0 || x == 1.0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1.0 / x;

        double res = myPow1(x, n / 2);
        res = res * res;

        //如果是奇数
        if ((n & 1) == 1 && n > 0) res = res * x; // 就是判断奇偶，=1为奇数，比%效率更高
        if ((n & 1) == 1 && n < 0) res = res * 1 / x;

        return res;
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow2(x, n >> 1); // n>>1就是n/2，但是右移效率更高
        double rest = myPow2(x, n & 1);
        return half * half * rest;
    }
}
