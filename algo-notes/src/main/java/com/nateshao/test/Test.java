package com.nateshao.test;

import java.util.Objects;

/**
 * @date Created by 邵桐杰 on 2022/5/9 12:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Test {

    @org.junit.Test
    public void int_to_string() { 
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            String s1 = String.valueOf(i);
            System.out.print(" "+s1);
            System.out.println(getType(s1));
        }
    }
    static String getType(Object a) {
        return a.getClass().toString();
    }
}
