package com.nateshao.sword_offer3.day27;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @date Created by 邵桐杰 on 2022/7/24 17:07
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class Day27_maxSlidingWindow {
//    class MonotonicQueue {
//        LinkedList<Integer> q = new LinkedList<>();
//        public void push(int n) {
//            while (!q.isEmpty() && q.getLast() < n) {
//                q.pollLast();
//            }
//            q.addLast(n);
//        }
//
//        public int max() {
//            return q.getFirst();
//        }
//
//        public void pop(int n) {
//            if (n == q.getFirst()) {
//                q.pollFirst();
//            }
//        }
//    }
//
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        MonotonicQueue window = new MonotonicQueue();
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i < k - 1) {
//                window.push(nums[i]);
//            } else {
//                window.push(nums[i]);
//                res.add(window.max());
//                window.pop(nums[i - k + 1]);
//            }
//        }
//        int[] arr = new int[res.size()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = res.get(i);
//        }
//        return arr;
//    }

    /**
     * 单调队列
     * 通过队列充当不断滑动的窗口，每次滑动记录其中的最大值：
     * 如何在 O(1) 时间计算最大值，只需要一个特殊的数据结构「单调队列」，push 方法依然在队尾添加元素，但是要把前面比自己小的元素都删掉，直到遇到更大的元素才停止删除。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }
        return res;
    }


    /**
     * k神
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if (i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst();
            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if (i >= 0) res[i] = deque.peekFirst();
        }
        return res;
    }
}
