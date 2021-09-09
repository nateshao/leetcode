package com.nateshao.day02_Arrays.demo06_Generic_Data_Structures;

/**
 * @date Created by 邵桐杰 on 2021/9/9 9:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.add(1, 100);// [0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);

        arr.addFirst(-1); // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2); // [-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);

        arr.removeElement(4); // [-1, 0, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println(arr);

        arr.removeFirst(); // [0, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println(arr);
    }
}
