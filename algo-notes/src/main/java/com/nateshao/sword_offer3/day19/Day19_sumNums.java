package com.nateshao.sword_offer3.day19;

/**
 * @date Created by 邵桐杰 on 2022/7/20 10:27
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Day19_sumNums {
    public static void main(String[] args) {
        System.out.println("sumNums(10) = " + sumNums(10));
    }
    /**
     * 递归
     * n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
