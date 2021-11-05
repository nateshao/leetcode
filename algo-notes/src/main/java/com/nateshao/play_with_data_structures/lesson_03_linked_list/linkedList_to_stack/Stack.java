package com.nateshao.play_with_data_structures.lesson_03_linked_list.linkedList_to_stack;

/**
 * @date Created by 邵桐杰 on 2021/11/5 22:49
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
