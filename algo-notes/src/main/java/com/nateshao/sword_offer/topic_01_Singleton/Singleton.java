package com.nateshao.sword_offer.topic_01_Singleton;

/**
 * @date Created by 邵桐杰 on 2021/11/9 23:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 面试题2：实现Singleton模式
 * 单例设计模式：思路：非线程安全与线程安全
 * 代码实现：线程安全的懒汉式：静态内部类
 */
public class Singleton {
    private Singleton(){}
    private static class SingletonHandler{
        private static Singleton outInstance =  new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHandler.outInstance;
    }

}
