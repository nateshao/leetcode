package com.nateshao.sword_offer3.day6;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/6/17 9:42
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class Day6_mirrorTree {
    /**
     * 方法一：递归法
     * 根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
     * 递归解析：
     * 终止条件： 当节点 root 为空时（即越过叶节点），则返回 null ；
     * 递推工作：
     * 初始化节点 tmp ，用于暂存 root 的左子节点；
     * 开启递归 右子节点 mirrorTree(root.right) ，并将返回值作为 root 的 左子节点 。
     * 开启递归 左子节点 mirrorTree(tmp) ，并将返回值作为 root 的 右子节点 。
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left; // 暂存左节点
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(node);
        return root;
    }


    /**
     * 利用辅助队列（栈）(bfs)
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
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
