package com.nateshao.sword_offer2.Code_17_printNumbers;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 11:47
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[] res = printNumbers(3);
        for (int re : res) {
            System.out.print(" " + re);
        }
    }
    /**
     * 最大的 1 位数是 9 ，最大的 2 位数是 99 ，最大的 3 位数是 999 。
     * 则可推出公式：end = 10^n - 1
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i+1;
        }
        return res;
    }

}