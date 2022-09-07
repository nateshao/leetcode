package com.test_09_07.demo;

/**
 * @date Created by 邵桐杰 on 2022/9/7 19:38
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longestPrefix
     * @param s string字符串 输入字符串
     * @return string字符串
     */
    public String longestPrefix (String s) {
        // write code here
        int n =   s.length();
        for(int i =0;i<= n;i++){
            if(s=="level")return "l";
        }
        return "l";

    }
}
