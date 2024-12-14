package com.nateshao.sword_offer2.code_65_add;

/**
 * @date Created by 邵桐杰 on 2022/10/3 17:40
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 位运算
     * @param a
     * @param b
     * @return
     */
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
}
