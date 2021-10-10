package com.nateshao.basic_class_01;

/**
 * @date Created by 邵桐杰 on 2021/9/23 11:58
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 用数组结构实现大小固定的队列
 */
public class ArrayToQueue {
    private int[] arr;
    private int size;
    private int start;
    private int end;

    /**
     * 初始化队列
     *
     * @param initSize
     */
    public ArrayToQueue(int initSize) {
        if (initSize < 0) { // 如果给定的值 < 0，报错
            throw new IllegalArgumentException("The init size is less than 0！");
        }
        arr = new int[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    /**
     * 进队列
     *
     * @param obj
     */
    public void EnQueue(int obj) {
        if (size == arr.length) { // 如果 size 等于队列长度，说明队列已满，不能进队列，报错。
            throw new IndexOutOfBoundsException("The queue is full！");
        }
        arr[start] = obj;
        start = start == arr.length ? 0 : start + 1;// start 如果等于队列长度，重新变为 0，否则 加 1。
        size++;// 队列中的元素数量减 1。
    }

    /**
     * 出队列
     *
     * @return
     */
    public int DeQueue() {
        if (size == 0) {        // 如果 size 等于 0 ，说明队列为空，不能出队列，报错
            throw new IndexOutOfBoundsException("The queue is empty！");
        }
        int temp = end;
        end = end == arr.length ? 0 : end + 1; // end 如果等于队列长度，重新变为 0，否则 加 1。
        return arr[temp];       // 队列中的元素数量减 1。

    }


}
