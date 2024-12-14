package com.nateshao.sword_offer3.day21;

/**
 * @date Created by 邵桐杰 on 2022/7/23 0:01
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class Day21_add {

    public int add(int a, int b) {
        if (a == 0 || b == 0) return a == 0 ? b : a;
        // 设 a = 1001
        // 设 b = 0101
        // 求和 1100
        int sum = a ^ b;
        // 进位 0001 << 1 = 0010
        int carry = (a & b) << 1;
        // add(1100, 0010)
        return add(sum, carry);
    }

    public int add2(int a, int b) {
        if (a == 0 || b == 0) return a == 0 ? a : b;
        // 假设 a = 1001
        // 假设 b = 0101
        // 求和 1100
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

}
