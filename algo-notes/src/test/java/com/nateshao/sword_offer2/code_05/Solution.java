package com.nateshao.sword_offer2.code_05;

/**
 * @date Created by 邵桐杰 on 2022/5/24 19:29
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c==' ')sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}
