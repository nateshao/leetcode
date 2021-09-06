package com.nateshao.day02_Arrays.demo04_Query_and_Update_Element;

import java.util.ArrayList;

/**
 * @date Created by 邵桐杰 on 2021/9/6 12:23
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 数组demo
 */
public class Main {
    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,100);
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);
    }
}
