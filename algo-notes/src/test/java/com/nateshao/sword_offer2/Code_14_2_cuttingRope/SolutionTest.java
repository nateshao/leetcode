package com.nateshao.sword_offer2.Code_14_2_cuttingRope;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 10:13
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
    public static void main(String[] args) {

    }

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long sum = 1;
        while (n > 4) {
            n -= 3;
            sum *= 3;
            sum %= 1000000007;
        }
        return (int) (sum * n % 1000000007);
    }

}