package com.nateshao.sword_offer3.day17;

import java.util.PriorityQueue;

/**
 * @date Created by 邵桐杰 on 2022/7/19 23:22
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Code295_MedianFinder {
    // 本题的核心思路是使用两个优先级队列。
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public Code295_MedianFinder() {
        // 初始化大根堆，小根堆
        large = new PriorityQueue<>(); //  小顶堆，保存较大的一半
        small = new PriorityQueue<>((a, b) -> {
            return b - a; // 大顶堆，保存较小的一半
        });
    }


    // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
    public double findMedian() {
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        return (large.peek() + small.peek()) / 2.0;
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }


}
