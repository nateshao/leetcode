package com.nateshao.sword_offer3.day20;

/**
 * @date Created by 邵桐杰 on 2022/7/20 22:01
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day20_myPow {
    /**
     *
     * @param a
     * @param k
     * @return
     */
    public double myPow(double a, int k) {
        if (k == 0) return 1;
        if (k == Integer.MIN_VALUE) {
            // 把 k 是 INT_MIN 的情况单独拿出来处理
            // 避免 -k 整型溢出
            return myPow(1 / a, -(k + 1)) / a;
        }
        if (k < 0) return myPow(1 / a, -k);
        if (k % 2 == 1) {
            // k 是奇数
            return (a * myPow(a, k - 1));
        } else {
            // k 是偶数
            double sub = myPow(a, k / 2);
            return (sub * sub);
        }
    }
}
