package com.nateshao.sword_offer.topic_25_levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date Created by 邵桐杰 on 2021/11/29 14:57
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 从上到下打印二叉树 思路：利用队列（链表）辅助实现。
 *
 * add 增加一个元索 如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * offer 添加一个元素并返回true 如果队列已满，则返回false
 * poll 移除并返问队列头部的元素 如果队列为空，则返回null
 * peek 返回队列头部的元素 如果队列为空，则返回null
 * put 添加一个元素 如果队列满，则阻塞
 * take 移除并返回队列头部的元素 如果队列为空，则阻塞
 */
public class Solution {

    /**
     *  队列
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];//空树则返回空数组
        ArrayList<Integer> list = new ArrayList<>();// 申请一个动态数组 ArrayList 动态添加节点值
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 根结点先入队
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();// 取出当前队首元素
            list.add(node.val);
            if (node.left != null) queue.offer(node.left);// 左子节点入队
            if (node.right != null) queue.offer(node.right);// 右子节点入队
        }
        // 将 ArrayList 转为 int数组并返回
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
