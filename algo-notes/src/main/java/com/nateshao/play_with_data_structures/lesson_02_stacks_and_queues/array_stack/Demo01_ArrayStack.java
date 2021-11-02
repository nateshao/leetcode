package com.nateshao.play_with_data_structures.lesson_02_stacks_and_queues.array_stack;

import com.nateshao.play_with_data_structures.lesson_02_stacks_and_queues.array_stack.ArrayStack;

/**
 * @date Created by 邵桐杰 on 2021/11/1 23:41
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Demo01_ArrayStack {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}