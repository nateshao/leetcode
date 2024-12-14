package com.nateshao.zijie_code_66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/3/17 9:26
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
public class Day10_inorderTraversal {
    /**
     * 动态规划思路
     * 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    /**
     * 回溯算法思路
     * 返回前序遍历结果
     *
     * @param root
     * @return
     */
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * 二叉树遍历函数
     *
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
