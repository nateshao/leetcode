package com.nateshao.test_07_25;

import com.nateshao.sword_offer.topic_01_Singleton.Singleton;

/**
 * @date Created by 邵桐杰 on 2022/7/25 20:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 实现一个单例类
 */
public class Singletence {
    /**
     * 1，创建类型变量
     * 2，构造方法
     * 3，单例实现
     */
    private static Singletence singletence = null;

    //1,2,34,
    private Singletence() {
    }

    synchronized public static Singletence getSingletence() {
        if (singletence == null) {
            singletence = new Singletence();
        }
        return singletence;
    }

}
