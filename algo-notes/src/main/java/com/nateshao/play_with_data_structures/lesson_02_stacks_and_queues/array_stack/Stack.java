package com.nateshao.play_with_data_structures.lesson_02_stacks_and_queues.array_stack;

/**
 * @date Created by 邵桐杰 on 2021/11/2 11:43
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}

