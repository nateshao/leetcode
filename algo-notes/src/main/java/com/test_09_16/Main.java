package com.test_09_16;

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

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && Character.isLetterOrDigit(s.charAt(left))) ;
            left++;
            while (left < right && Character.isLetterOrDigit(s.charAt(right))) ;
            right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
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
