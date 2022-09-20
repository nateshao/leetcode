package com.nateshao.sword_offer2.Code_14_2_cuttingRope;

/**
 * @date Created by 邵桐杰 on 2022/3/7 19:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * <p>
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("cuttingRope(10) = " + cuttingRope(10));
    }

    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long sum = 1;
        while (n > 4) {
            sum *= 3;
            sum %= 1000000007;
            n -= 3;
        }
        return (int) (sum * n % 1000000007);
    }
}
