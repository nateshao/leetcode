package com.nateshao.test_10_21;

/**
 * @date Created by 邵桐杰 on 2022/10/21 14:30
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 请编写以下功能的函数：在一个字符串（str1）中查找另外一个串（str2）的最大前缀，
 * 比如str1 = "abcdefg", str2 = "descript"，那么最大前缀是"de"，
 * 返回这个前缀在str1中的位置以及前缀字符串。要求函数是对大小写不敏感的
 */
public class Main {
    /**
     * 思路：
     * @param str1
     * @param str2
     * @return
     */
    public String match(String str1,String str2){
        if (str2==null||str2.length()==0)return "";
        char[] chars = str2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            if(str1.charAt(i) == 'a'|| 'z'+32);
        }

        return str2;
    }

}
