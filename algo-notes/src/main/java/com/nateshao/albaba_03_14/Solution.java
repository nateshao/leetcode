package com.nateshao.albaba_03_14;

/**
 * @date Created by 邵桐杰 on 2022/3/14 19:31
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 16进制转化为2进制，有多少个1
 */
public class Solution {
    public static void main(String[] args) {
        int result = getNumber("0x3f");
        System.out.println("result = " + result);
    }

    /**
     * 16进制先转成10进制，然后再转2进制
     * @param s
     * @return
     */
    public static int getNumber(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            aChar/=2;
            count++;
        }
        return count;
    }
}
