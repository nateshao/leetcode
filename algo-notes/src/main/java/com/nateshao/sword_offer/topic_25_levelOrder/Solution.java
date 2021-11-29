package com.nateshao.sword_offer.topic_25_levelOrder;

import java.util.*;

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
    public int[] levelOrder1(TreeNode root) {
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

    /******************************* 递归 *****************************************/
    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        levelOrder(root, list);
        return list;
    }
    public void levelOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
        }
        if (root.right != null) {
            list.add(root.right.val);
        }
        levelOrder(root.left, list);
        levelOrder(root.right, list);
    }


    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     *剑指 Offer 32 - III. 从上到下打印二叉树 III
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) deque.add(root);
        while(!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if(deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if(node.right != null) deque.addFirst(node.right);
                if(node.left != null) deque.addFirst(node.left);
            }
            res.add(tmp);
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
