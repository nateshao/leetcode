package com.nateshao.test_2023;

/**
 * @date Created by 邵桐杰 on 2023/1/8 15:04
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 125. 验证回文串
 */
public class Code125_isPalindrome {
    public static void main(String[] args) {

    }

    /**
     * 验证是否回文
     * 将字符串转换为小写，然后放进stringbuilder。再比较
     *
     * 字符串转字符数组
     * 遍历字符，(c>='a'&&c<='z' )||(c>='0'||c<='9')
     *
     * @param                                                                                s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder res = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                res.append(c);
            }
        }
        return res.toString().equals(res.reverse().toString());
    }
}
