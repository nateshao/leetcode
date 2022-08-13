package com.nateshao.test;

import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

/**
 * @date Created by 邵桐杰 on 2022/8/13 18:31
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */

public class MessagePackTest {

    @Test
    public void test01() throws Exception {
        String msg = "千羽的编程时光 https://nateshao.gitlab.io/";
        MessagePack messagePack = new MessagePack();

        // 序列化
        final byte[] bytes = messagePack.write(msg);

        // 反序列化
        // 千羽的编程时光 https://nateshao.gitlab.io/
        final String s = messagePack.read(bytes, String.class);

        // 反序列化
        // "千羽的编程时光 https://nateshao.gitlab.io/"
        final String s2 = messagePack.read(bytes).toString();

        // 反序列化
        // "???????? https://nateshao.gitlab.io/"
        //final String s0 = messagePack.read(bytes).toString();
        //final String s = new String(s0.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        System.out.println(s);
        System.out.println(s2);
    }




    @Test
    public void test02() throws Exception{
        String msg = "{\"pId\":9527,\"pName\":\"华安\",\"isMarry\":true}";
        MessagePack messagePack = new MessagePack();
        // 序列化
        final byte[] bytes = messagePack.write(msg);
        // 反序列化
        // {"pId":9527,"pName":"华安","isMarry":true}
        String s = messagePack.read(bytes, Templates.TString);
        for (byte aByte : bytes) {
            System.out.print(aByte);
        }
        System.out.println();
//        System.out.println("序列化："+bytes);
        System.out.println("反序列化："+s);

    }

    @Test
    public void test03() throws Exception{
        String msg = "{\"pId\":9527,\"pName\":\"华安\",\"isMarry\":true}";
        MessagePack messagePack = new MessagePack();
        // 序列化
        final byte[] bytes = messagePack.write(msg);
        // 反序列化
        // "{\"pId\":9527,\"pName\":\"华安\",\"isMarry\":true}"
        final String s = messagePack.read(bytes).toString();
        System.out.println(s);
    }
}
