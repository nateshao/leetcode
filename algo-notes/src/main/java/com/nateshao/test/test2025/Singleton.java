package com.nateshao.test.test2025;

/**
 * @date Created by 邵桐杰 on 2022/8/28 10:43
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Singleton {
//   // 使⽤ volatile 可以禁⽌ JVM 的指令重排，保证在多线程环境下也能正常运⾏。
//    private volatile static Singleton uniqueInstance;
//
//    private Singleton() {
//    }
//
//    public static Singleton getUniqueInstance() {
//        //先判断对象是否已经实例过，没有实例化过才进⼊加锁代码
//        if (uniqueInstance == null) {
//            //类对象加锁
//            synchronized (Singleton.class) {
//                if (uniqueInstance == null) {
//                    uniqueInstance = new Singleton();
//                }
//            }
//        }
//        return uniqueInstance;
//    }

    /**
     * 非线程安全：这个实现存在多线程安全问题：当多个线程同时调用 getInstance() 时，可能会创建多个实例。
     */
//    private static Singleton instance;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 线程安全懒汉单例（加锁）
     */
//    private static Singleton instance;
//    private Singleton() {}
//
//    /**
//     * 线程安全懒汉单例（加锁）
//     * 优点：线程安全：synchronized 保证了多线程环境下的安全性。
//     * 缺点：性能较差：每次调用 getInstance() 方法时都需要加锁，可能会影响性能。
//     * @return
//     */
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 双重检查锁定懒汉单例
     */
//    private static volatile Singleton instance;
//    private Singleton() {}
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {                 // 第一重检查
//            synchronized (Singleton.class) {
//                if (instance == null) {         // 第二重检查
//                    instance = new Singleton(); // 延迟实例化
//                }
//            }
//        }
//        return instance;
//    }







}