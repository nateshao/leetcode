package com.nateshao.source.code.java_base.constructor;

/**
 * @date Created by 邵桐杰 on 2023/2/21 16:58
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Demo2_Student {
    static {
        System.out.println("1—Demo2_Student静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("2-我是main方法");

        Student s1 = new Student();
        Student s2 = new Student();
    }
    static class Student {
        {
            System.out.println("Student 静态代码块");
        }

        {
            System.out.println("Student 构造代码块");
        }

        public Student() {
            System.out.println("Student 构造方法");
        }
    }
}
