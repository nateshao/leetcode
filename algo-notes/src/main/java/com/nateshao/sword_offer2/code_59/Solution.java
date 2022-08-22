package com.nateshao.sword_offer2.code_59;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @date Created by 邵桐杰 on 2022/8/21 21:01
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 * 面试题59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 */
public class Solution {
    class MaxQueue {

        private Deque<Integer> queue;
        private Deque<Integer> help;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public int max_value() {
            return queue.isEmpty() ? -1 : help.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while(!help.isEmpty() && value > help.peekLast()) {
                help.pollLast();
            }
            help.offer(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) {
                return -1;
            }
            int val = queue.pop();
            if(help.peek() == val) {
                help.pop();
            }
            return val;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
}















