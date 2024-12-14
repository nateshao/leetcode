package com.nateshao.sword_offer.topic_49_lastRemaining;

/**
 * @date Created by 邵桐杰 on 2022/2/24 21:51
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * <p>
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class Solution {
    public static void main(String[] args) {
        int i = lastRemaining(5, 3);
        System.out.println("i = " + i);
    }

    /**
     * 利用公式法：f[n] = (f[n-1] + k) mod n，或使用循环链表实现
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            // i 个人时删除数的索引等于 i-1 个人时删除数的索引+k(再对i 取余)
            x = (x + m) % i;
        }
        return x;
    }
}
