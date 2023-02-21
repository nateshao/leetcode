package com.nateshao.source.code.java_base.constructor;

/**
 * @date Created by 邵桐杰 on 2023/2/21 16:43
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Demo1_Constructor {
    public static void main(String[] args) {
        Person p = new Person();                //在一创建对象的时候,系统就帮我调用了构造方法
        //p.Person();							//构造方法不能用对象调用
        p.show();      //张三...23
        Person p2 = new Person();                //再次创建对象
        p2.show();      //张三...23
    }

    static class Person {
        private String name;
        private int age;

        //构造方法
        public Person() {
            //System.out.println("Hello World!");
            //return;								//构造方法也是有return语句的,格式是return;
            name = "张三";
            age = 23;
        }

        public void show() {
            System.out.println(name + "..." + age);
        }
    }
}
