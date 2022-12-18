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
}