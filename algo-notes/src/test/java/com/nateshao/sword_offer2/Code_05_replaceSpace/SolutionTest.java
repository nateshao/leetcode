package com.nateshao.sword_offer2.Code_05_replaceSpace;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/17 23:40
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 初始化一个 StringBuilder，记为 res ；
     * 遍历列表 s 中的每个字符 c ：
     * 当 c 为空格时：向 res 后添加字符串 "%20" ；
     * 当 c 不为空格时：向 res 后添加字符 c ；
     * 将列表 res 转化为字符串并返回。
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
//       return s.replace(" ","%20";
    }
}