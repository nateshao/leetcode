package com.nateshao.day02_Arrays;

/**
 * @date Created by 邵桐杰 on 2021/9/6 10:56
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Demo02_Create_Our_Own_Array {
    private int[] data;
    private int size;

    public Demo02_Create_Our_Own_Array(int[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public Demo02_Create_Our_Own_Array() {

    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
