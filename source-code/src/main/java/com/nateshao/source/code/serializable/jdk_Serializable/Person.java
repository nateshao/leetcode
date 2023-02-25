package com.nateshao.source.code.serializable.jdk_Serializable;

import java.io.Serializable;

/**
 * @date Created by 邵桐杰 on 2023/2/25 13:21
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name = null;
    private Integer age = null;
    private SerializeDemo01.Sex sex;

    public Person() {
        System.out.println("调用默认构造函数");
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SerializeDemo01.Sex getSex() {
        return sex;
    }

    public void setSex(SerializeDemo01.Sex sex) {
        this.sex = sex;
    }

    public Person(String name, Integer age, SerializeDemo01.Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", sex=" + sex + '}';
    }
}


