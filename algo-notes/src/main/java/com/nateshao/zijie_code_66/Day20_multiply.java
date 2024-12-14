package com.nateshao.zijie_code_66;

/**
 * @date Created by 邵桐杰 on 2022/3/27 20:40
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/multiply-strings/
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class Day20_multiply {
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        System.out.println(multiply(num1, num2));
    }

    /**
     * 对于比较小的数字，做运算可以直接使用编程语言提供的运算符，
     * 但是如果相乘的两个因数非常大，语言提供的数据类型可能就会溢出。
     * 一种替代方案就是，运算数以字符串的形式输入，
     * 然后模仿我们小学学习的乘法算术过程计算出结果，并且也用字符串表示。
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                sum += res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (; i < res.length; i++) {
            sb.append(res[i] + "");
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
