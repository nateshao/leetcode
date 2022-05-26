package com.nateshao.sword_offer3.day3;

/**
 * @date Created by 邵桐杰 on 2022/5/26 23:12
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Day3_1replaceSpace {
    /**
     * 方法一：遍历添加
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c==' ')res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
