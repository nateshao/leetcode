package com.nateshao.test;

import java.io.*;
import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/5/25 10:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class FileDemo {
    /**
     * 思路：
     * 通过控制台 写入和读取文件
     * 1. 输入指令 todo add Task 001 ，写入到文件
     * 2. 输入指令 todo list ，将写入的文件内容读取出来
     * 3. 输入remove
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("file.txt");
        // 控制台输入 todo add Task 001 ，写入Task 001
        /**
         * 如果输入指令 == todo add Task 001 写入Task 001
         * 如果输入指令 ==  todo list  循环遍历写入文件，打印
         * 如果输入指令 == remove xxx  删除指定的文件
         */
        while (sc.hasNext()){
            fw.write("Task 001");
        }
    }
}
