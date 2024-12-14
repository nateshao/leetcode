package com.nateshao.source.code.serializable.jdk_Serializable;

import java.io.*;

/**
 * @date Created by 邵桐杰 on 2023/2/25 16:31
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("D:\\temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person person = new Person();
        person.setName("千羽");
        person.setAge(18);
        person.setSex(SerializeDemo01.Sex.MALE);


        oos.writeObject(person);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("D:\\temp.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);
        Object obj = oin.readObject(); // 读取对象
        oin.close();
        fis.close();
        System.out.println(obj);
    }
}
