package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date Created by 邵桐杰 on 2023/2/7 21:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 多线程打印abc
 */
public class PrintABC {
    private static int ans = 0;
    private static final int count = 30;


    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (ans >= count) {
                        lock.unlock();
                        return;
                    }
                    if (ans % 3 == 0) {
                        System.out.println("A");
                        ans++;
                    }
                    lock.unlock();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (ans >= count) {
                        lock.unlock();
                        return;
                    }
                    if (ans % 3 == 1) {
                        System.out.println("B");
                        ans++;
                    }
                    lock.unlock();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (ans >= count) {
                        lock.unlock();
                        return;
                    }
                    if (ans % 3 == 2) {
                        System.out.println("C");
                        ans++;
                    }
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
