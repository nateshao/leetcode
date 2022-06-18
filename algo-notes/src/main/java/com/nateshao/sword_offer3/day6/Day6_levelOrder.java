package com.nateshao.sword_offer3.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date Created by 邵桐杰 on 2022/6/16 20:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 */
public class Day6_levelOrder {
    /**
     * 队列
     * <p>
     * 算法流程：
     * 特例处理： 当树的根节点为空，则直接返回空列表 [] ；
     * 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
     * BFS 循环： 当队列 queue 为空时跳出；
     * 出队： 队首元素出队，记为 node；
     * 打印： 将 node.val 添加至列表 tmp 尾部；
     * 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
     * 返回值： 返回打印结果列表 res 即可
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
            if (node.left != null) queue.offer(node.left);// 取出当前队首元素
            if (node.right != null) queue.offer(node.right);// 右子节点入队
        }
        // 将 ArrayList 转为 int数组并返回
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;


    }

    public int[] levelOrder2(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}
