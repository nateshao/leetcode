package com.nateshao.sword_offer.topic_51_add;

/**
 * @date Created by 邵桐杰 on 2022/2/24 22:34
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 复杂度分析：
 * 时间复杂度 O(1) ： 最差情况下（例如 a = 0x7fffffff , b = 1 时），需循环 32 次，使用 O(1)时间；每轮中的常数次位操作使用 O(1) 时间。
 * 空间复杂度 O(1)： 使用常数大小的额外空间。
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("add(1, 2) = " + add(1, 2));
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;// 计算个位
            b = (a & b) << 1; // 计算进位
            a = sum;
        }
        return a;
    }
}
