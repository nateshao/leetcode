package com.nateshao.one_question_per_day.code_2022.january;


import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/1/1 11:17
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Solution_2022_01_03_convert {
    public static void main(String[] args) {
    }
//    public String convert(String s, int numRows) {
//        if(numRows == 1)
//            return s;
//        int len = Math.min(s.length(), numRows);
//        String []rows = new String[len];
//        for(int i = 0; i< len; i++) rows[i] = "";
//        int loc = 0;
//        boolean down = false;
//
//        for(int i=0;i<s.length();i++) {
//            rows[loc] += s.substring(i,i+1);
//            if(loc == 0 || loc == numRows - 1)
//                down = !down;
//            loc += down ? 1 : -1;
//        }
//
//        String ans = "";
//        for(String row : rows) {
//            ans += row;
//        }
//        return ans;
//    }
}
















