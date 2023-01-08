package com.nateshao.test_2022.test_11_11;

import java.math.BigDecimal;

/**
 * @date Created by 邵桐杰 on 2022/11/11 14:39
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 将字符串转换为数字
 */
public class Main {
    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "123456789";
        String str3 = "1234.12";
        String str4 = "1234.5678";
        String str5 = "210102199906180520908007";

        //转换时必须保证字符串内的每一个字符都是数字
        int num1 = Integer.parseInt(str1);
        long num2 = Long.parseLong(str2);
        float num3 = Float.parseFloat(str3);
        double num4 = Double.parseDouble(str4);

        //其他方法
        Integer a = new Integer(str1);
        int b = Integer.parseInt(str1);//此方法用的比较多
        Integer c = Integer.valueOf(str1);

        //对于特别长的数字字符串，已经超出了long的范围，要用BigDecimal
        //如果用int或long接收会出现java.lang.NumberFormatException异常
        //需要BigDecimal类来接收
        BigDecimal big = new BigDecimal(str5);

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(big);
    }
//    public int strToInt(String str){
//        StringBuilder res = new StringBuilder();
////        int[] res = new int[str.length()];
//        if (str == null || str.length()==0)return 0;
//        String s = str.toLowerCase();
//        for (int i = 0; i < s.length(); i++) {
//            while (s.charAt(i)>='a'||s.charAt(i)<='z'){
//                // 转数字
//                // s.chars(i)-32;
//                int a = s.charAt(i) -'0';
//                res.append(a);
//            }
//        }
////        return res;
//    }
}
