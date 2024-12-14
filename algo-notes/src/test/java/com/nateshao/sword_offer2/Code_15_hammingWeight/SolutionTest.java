package com.nateshao.sword_offer2.Code_15_hammingWeight;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 11:02
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    public static void main(String[] args) {
        int i = hammingWeight(11);
        System.out.println("i = " + i);
    }

    /**
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
//        return Integer.bitCount(n);
    }
}