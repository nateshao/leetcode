package com.nateshao.day02_Arrays.demo07_Dynamic_Array;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/9/9 9:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) {
//        Array<Integer> arr = new Array<>();
//        for (int i = 0; i < 10; i++)
//            arr.addLast(i);
//        System.out.println(arr);
//
//        arr.add(1, 100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,100);
        System.out.println("array = " + array);
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("Main.main");

        System.out.println("-----------------------------------");
        array.add(1,102);
        System.out.println("array = " + array);
        System.out.println("-----------------------------------");
        array.addFirst(-1);
        System.out.println("array = " + array);
        System.out.println("-----------------------------------");
    }
}
