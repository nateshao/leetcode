package com.nateshao.test;

import java.io.*;
import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/5/25 14:19
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter("E:/IOTest/dest.txt"));
        Scanner intput = new Scanner(System.in);
        StringBuilder str = new StringBuilder(intput.next());
        int temp = 1;
        // 输入end就结束循环条件
        while (!str.toString().equals("end")) {
            str.append(intput.nextLine());
            String[] s1 = str.toString().split(" ");
            if (s1[0].equals("todo")) {
                if (s1[1].equals("add")) {
                    write(str, bw, temp);
                    temp = temp + 1;
                } else if (s1[1].equals("list")) {
                    list();
                }
            }
            else {
                System.out.println("无效命令");
            }
            str = new StringBuilder(intput.next());
        }

        // 关闭IO流对象
        try {
            if (bw != null) {
                bw.close(); // 关闭过滤流时,会自动关闭它所包装的底层节点流
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(StringBuilder str, BufferedWriter bw, int temp) {
        String[] s2 = str.toString().split(" ");
        try {
            bw.write(String.valueOf(temp));
            bw.write(" ");
            bw.write(s2[0]);
            bw.write(" ");
            bw.write(s2[1]);
            bw.write(" ");
            bw.write(s2[2]);
            bw.write(" ");
            if (s2[3].equals("")) {
            } else {
                bw.write(s2[3]);
            }
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void list() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:/IOTest/dest.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String text = null;
        while ((text = bufferedReader.readLine()) != null) {
            stringBuilder.append(text + "\n");
        }
        System.out.println(stringBuilder.toString());
    }
    public static void remove(int i) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:/IOTest/dest.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String text = null;
        while ((text = bufferedReader.readLine()) != null) {
            stringBuilder.deleteCharAt(i);
        }
        System.out.println(stringBuilder.toString());
    }
}
