package com.nateshao.test_2022.test_09_16;

/**
 * @date Created by 邵桐杰 on 2022/9/16 16:33
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/valid-palindrome/
 */
public class Main {
    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。
     * 则可以认为该短语是一个 回文串 。字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     * Stringbuilder
     * <p>
     * 如果str==null return true
     * 遍历str，转换为字符数字
     * 如果 c>='0'||c<='0' && c>='a'||c<='z'
     * res.append(c)
     * return res
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());

    }

    public boolean huiwenString(String str) {
        StringBuilder sb = new StringBuilder(str);
        StringBuilder s2 = sb.reverse();
        if (s2.equals(sb) == true) {
            System.out.println("字符串" + str + "是回文");
        } else {
            System.out.println("字符串" + str + "不是回文");
        }
        return false;
    }
}
