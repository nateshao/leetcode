package com.nateshao.sword_offer.topic_07_CQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2021/11/18 15:03
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 用两个栈实现队列
 */
public class CQueue {

    //两个栈，一个出栈，一个入栈
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }


    /**
     * 两个栈实现队列
     *
     * 思路：
     *
     * 1. 初始化两个栈。栈push只进，栈pop只出。
     * 2. 比如：12345存入栈push，然后倒序（要一次倒完）存入栈pop
     * 3. 在将5输出。
     * 4. 两个原则：（1）栈push倒出栈pop时，要一次性倒完，不能倒2个；
     *             （2）栈pop有数据时，栈push不能导入数据。否则会乱
     */
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }


    /**
     * 两个队列实现栈
     *
     * 思路：两个队列，把所有数放到队列上，留下一个给用户输出。来回反复
     * 1. 初始化两个队列，队列Data和队列Help
     * 2. 进入12345到队列Data，好了，要把5放出来。
     * 3. 先将1234存入队列help，123留在队列data里。然后把4输出。
     * 4. 先把123放在队列Data里面。12留在队列help。然后把3放出去。
     */
    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }
}
