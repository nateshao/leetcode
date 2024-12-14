package com.nateshao.sword_offer2.Code_49_nthUglyNumber;

/**
 * @date Created by 邵桐杰 on 2022/4/19 20:40
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("nthUglyNumber(10) = " + nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] arr = new int[n];
        arr[0] = 1;
        int multiply2 = 0, multiply3 = 0, multiply5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[multiply2] * 2, Math.min(arr[multiply3]
                    * 3, arr[multiply5] * 5));
            arr[i] = min;
            if (arr[multiply2] * 2 == min) multiply2++;
            if (arr[multiply3] * 3 == min) multiply3++;
            if (arr[multiply5] * 5 == min) multiply5++;
        }
        return arr[n - 1];

    }
}
