package com.nateshao.play_with_data_structures.lesson_02_stacks_and_queues.array_queue;

/**
 * @date Created by 邵桐杰 on 2021/11/3 22:30
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
