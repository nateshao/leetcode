package com.nateshao.one_question_per_day.code_2022.july;

/**
 * @date Created by 邵桐杰 on 2022/7/8 9:15
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Code_07_07_RotatedNums {
    public static void main(String[] args) {
        int n = 1;
        System.out.println("RotatedNums() = " + RotatedNums(n));
    }

    /**
     * 题目二：找好数
     * 当整个数字绕平面内任一点旋转180°之后仍是其本身，我们称这个数为“好数”，
     * 例如“1”，“2”，“0”，"12021","69","96"。
     * 注意：我们使用的数字跟红绿灯上或者老式计算器一样的。
     * 给你长度n,我们需要统计长度为n的好数有多少个。
     * 说明：
     * 1.	我们要旋转的是整个好数，而不是每一位每一位旋转。
     * 2.	除0以外，好数不能含有前导0。
     * 3.	1<=n<=10
     * 例如：
     * 输入:
     * n = 1
     * 输出:
     * 5
     * 说明:
     * 5 个好数为 "0","1","2","5","8"
     * 输入:
     * n = 2
     * 输出:
     * 6
     * 说明:
     * 6 个好数为 "11","22","55","88","69","96"
     * @param n
     * @return
     */
    public static long RotatedNums(int n) {
        if (n == 1) return 5;
        long ret = 6;
        for (int i = 1; i < (n / 2); i++) ret *= 7;
        if (n % 2 == 1) ret *= 5;
        return ret;
    }
}

