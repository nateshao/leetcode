package com.nateshao.test.synchronized_demo;

/**
 * @date Created by 邵桐杰 on 2022/8/28 10:50
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SynchronizedDemo {
    public  void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
