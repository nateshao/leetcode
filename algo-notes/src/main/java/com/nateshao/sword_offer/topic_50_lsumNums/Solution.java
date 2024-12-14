package com.nateshao.sword_offer.topic_50_lsumNums;

/**
 * @date Created by 邵桐杰 on 2022/2/24 22:34
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("sumNums(9) = " + sumNums(9));
    }
    /**
     * 递归
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
