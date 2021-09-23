package com.nateshao.basic_class_01;

/**
 * @date Created by 邵桐杰 on 2021/9/23 11:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 用数组结构实现大小固定的栈
 */
public class ArrayToStack {
    private int[] arr;
    private int size;

    /**
     * 初始化栈
     *
     * @param initSize
     */
    public ArrayToStack(int initSize) {
        if (initSize < 0) {                 // 给定的初始值 < 0，报错
            throw new IllegalArgumentException("The init size is less than 0!");
        }
        arr = new int[initSize];
        size = 0;
    }

    /**
     * 入栈
     *
     * @param obj
     */
    public void push(int obj) {
        if (size == arr.length) {   // size 等于数组长度（栈的大小），说明栈已满，不能入栈。
            throw new ArrayIndexOutOfBoundsException("The stack is full!");
        }
        arr[size++] = obj;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (size == 0) {  // size 等于 0，说明栈空，不能出栈。
            throw new ArrayIndexOutOfBoundsException("The stack is empty!");
        }
        return arr[--size];
    }

    /**
     * 返回栈顶
     */
    public int peek() {
        if (size == 0) {  // size 等于 0，说明栈空，所以没有栈顶。
            throw new IndexOutOfBoundsException("The stack is empty!");
        }
        return arr[size - 1];
    }

}
