package com.nateshao.sword_offer2.Code_09_CQueue;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/9/18 13:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class CQueue_stack {
    Stack<Integer> A, B;
    public CQueue_stack() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }
    public void appendTail(int value) {
        A.add(value);
    }

    /**
     * 如果栈a为空，就返回-1；
     * 如果栈b不为null，移除栈b的元素
     * 当栈a不为null，栈b添加元素，移除栈b栈顶元素
     * @return
     */
    public int deleteHead() {
 		if (B.isEmpty()) {
 			if (A.isEmpty()) return -1;
 			while (!A.isEmpty()) {
                B.add(A.pop());
 			}
 			return B.pop();
 		} else return B.pop();
 	}

}
