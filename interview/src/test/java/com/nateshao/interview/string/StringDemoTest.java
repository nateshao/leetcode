package com.nateshao.interview.string;

import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @date Created by 邵桐杰 on 2022/12/18 22:56
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@SpringBootTest
public class StringDemoTest {
    /**
     * String s1 = “1”;创建了1个"1"对象，在常量池。
     * String s2 = new String(“1”);创建了两个"1"对象，一个在常量池，一个在heap区。
     * String s3 = “1”+“1”;创建了一个"11"对象，不在常量池，在heap区。
     */
    @Test
    public void demo() {
        String a = "we";
        String b = a + "chat";
        // 上下含义相同
        String c = "moz";
        String d = "bad";
        String f = c + d;
        System.out.println("f = " + f);
    }

    @Test
    public void demo2() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

//        //在堆中创建一个字符串对象; 这里不涉及字符串常量池
//        String m = new String("abc");
////由于字符串常量池中没有记录过"abc", 所以调用intern()方法后, 字符串常量池中生成一个引用, 该引用指向堆中的"abc"对象
//        String n = m.intern();
////n指向堆中的"abc"对象, m指向堆中的"abc"对象, 所以n和m指向相同的"abc", 打印true
//        System.out.println(m == n);


        //使用双引号创建字符串, 字符串常量池会记录该字符串
        String k = "abc";
//在堆中创建一个字符串对象; 这里不涉及字符串常量池
        String m = new String("abc");
//字符串常量池记录过"abc", 调用intern()方法后, 返回一个引用, 该引用指向首次出现的"abc"对象, 所以并不指向上一句创建的字符串对象!
        String n = m.intern();
//n指向首次出现的"abc"对象, m指向堆中新创建的"abc"对象, 所以n和m指向的是不同的"abc"对象, 打印false
        System.out.println(m == n);
    }

}