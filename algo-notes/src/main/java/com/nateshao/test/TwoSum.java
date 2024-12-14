package com.nateshao.test;

/**
 * @date Created by 邵桐杰 on 2022/6/2 14:29
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: 两个大整数相加
 * 大整数相加，要能运行，参数是两个string，考虑各种异常。
 * 返回String
 */
public class TwoSum {
    public static void main(String[] args) {
        String num1 = "100321";
        String num2 = "100321";
        String twoSum = twoSum(num1, num2);
        System.out.println(twoSum);
    }


    /**
     * "100" + "100" = "200"
     * 1，num1 为空，返回num2
     * 2，num2 为空，返回num1
     * (1)num1长度大于num2
     * <p>
     * 3，num1和num2为空，return 0
     * 4，num1和num2不为空，相加
     * 思路
     * (1)强转为数字相加
     * (2)
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String twoSum(String num1, String num2) {
        if (num1 == null) return num2;
        if (num2 == null) return num1;
        if (num1 == null || num2 == null) return null;
        char[] A = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] B = new StringBuilder(num2).reverse().toString().toCharArray();
        int maxlength = 0;
        if (A.length > B.length) {
            maxlength = A.length;
        }
        // 存新的数组
        int[] res = new int[maxlength + 1];
        for (int i = 0; i < res.length; i++) {
            // 相加 3目运算符
            int Ai = i < A.length ? A[i] - '0' : 0;
            int Bi = i < B.length ? B[i] - '0' : 0;
            res[i] = Ai + Bi;
            if (res[i] > 10) {
                res[i + 1] = res[i] + 1;
                res[i] %= 10;
            }
        }
        // 结果
        StringBuffer stringBuffer = new StringBuffer();
        if (res[res.length] == 1) {
            stringBuffer.append(1);
        }
        for (int i = 0; i < res.length-2; i++) {
            stringBuffer.append(res[i]);
        }
        return stringBuffer.toString();
    }

}
