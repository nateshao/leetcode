package com.nateshao.sword_offer.topic_10_numWays;

/**
 * @date Created by 邵桐杰 on 2021/11/19 23:34
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 青蛙跳台阶问题
 */
public class Solution {
    public static void main(String[] args) {
        int i = numWays(7);
        System.out.println("i = " + i);
        int i1 = JumpFloor(7);
        System.out.println("i1 = " + i1);
    }

    public static int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 思路：斐波那契数列思想
     *
     * @param n
     * @return
     */
    public static int JumpFloor(int n) {
        if (n < 3) {
            return n;
        }
        int result = 0;
        int preOne = 2;
        int preTwo = 1;
        for (int i = 3; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

}
