package com.nateshao.source.code.serializable.json_Serializable.serializable;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * @date Created by 邵桐杰 on 2023/2/25 17:11
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class User {
    /**
     * @JSONField 作用：自定义对象属性所对应的 JSON 键名
     * @JSONField 的作用对象:
     * 1. Field
     * 2. Setter 和 Getter 方法
     * 注意：
     * 1. 若属性是私有的，必须要有 set 方法，否则反序列化会失败。
     * 2. 若没有 @JSONField 注解，则直接使用属性名。
     */
    @JSONField(name = "NAME")
    private String name;
    @JSONField(name = "AGE")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
