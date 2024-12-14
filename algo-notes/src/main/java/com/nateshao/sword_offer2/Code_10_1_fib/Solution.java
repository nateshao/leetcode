package com.nateshao.sword_offer2.Code_10_1_fib;

/**
 * @date Created by 邵桐杰 on 2022/3/6 21:02
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("fib(5) = " + fib(5));
        System.out.println("fib2(5) = " + fib2(5));
    }

    /**f(5) = f(4)+f(3) = 3 + 2 = 5
     * f(4) = f(3)+f(2) = 3
     * f(3)= f(2)+f(1) = 2
     * f(2) = f(1)+f(0)  = 1
     * f(1)=1 ,f(0)=0
     * @param n
     * @return
     */
    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static int fib2(int n) {
        n = help(n);
        return n;
    }

    private static int help(int n) {
        if (n < 2) return n;
        return (help(n - 1) + help(n - 2)) % 1000000007;
    }

    /**
     * Java动态规划代码
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1, temp;

        for (int i = 2; i <= n; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp; // 每次运算都取模 避免越界
        }
        return b;

    }
}
