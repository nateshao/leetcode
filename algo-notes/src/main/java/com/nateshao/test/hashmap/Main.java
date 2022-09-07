package com.nateshao.test.hashmap;

import java.util.HashMap;

/**
 * @date Created by 邵桐杰 on 2022/9/5 21:42
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        HashMap map = new HashMap();
        String s1 = new String("123");
        String s2 = new String("123");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        Object obj = new Object();
        obj.equals(s1); // 比较两个对象内容是否相等
        obj.toString();
        obj.hashCode(); // 获取哈希码
        obj.notify(); // 多线程中唤醒功能
        obj.notifyAll(); // 多线程中唤醒所有等待线程的功能
        obj.wait();
        //Object 是所有类的根，是所有类的父类，所有对象包括数组都实现了 Object 的方法。



    }
}
