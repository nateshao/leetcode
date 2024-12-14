package com.nateshao.sword_offer2.Code_17_printNumbers;

/**
 * @date Created by 邵桐杰 on 2022/3/7 19:43
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("printNumbers(1) = " + printNumbers(1));
    }

    /**
     * 题目要求打印 “从 1 至最大的 n 位数的列表” ，因此需考虑以下两个问题：
     * <p>
     * 最大的 nn 位数（记为 end ）和位数 n 的关系： 例如最大的 1 位数是 99 ，最大的 2 位数是 9999 ，最大的 3 位数是 999999 。则可推出公式：
     * end = 10^n - 1
     * end=10
     * n
     * −1
     * <p>
     * 大数越界问题： 当 nn 较大时，end会超出 int32 整型的取值范围，超出取值范围的数字无法正常存储。但由于本题要求返回 int 类型数组，相当于默认所有数字都在 int32 整型取值范围内，因此不考虑大数越界问题。
     * 因此，只需定义区间 [1, 10^n - 1]和步长 1 ，通过 for 循环生成结果列表 res 并返回即可。
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(10^n)： 生成长度为 10^n的列表需使用 O(10^n) 时间。
     * 空间复杂度 O(1) ： 建立列表需使用 O(1)大小的额外空间（ 列表作为返回结果，不计入额外空间 ）。
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }

    public static int[] printNumbers2(int n) {
        int end = (int) Math.pow(10, n);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
