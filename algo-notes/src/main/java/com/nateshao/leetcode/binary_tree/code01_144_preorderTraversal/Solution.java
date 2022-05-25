package com.nateshao.leetcode.binary_tree.code01_144_preorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/4/23 14:39
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
public class Solution {
    // 法一
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    /**
     * 根左右
     * @param root
     */
    void traversal(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
    /************ 法二 ***************/
    /**
     * 一棵二叉树的前序遍历结果 = 根节点 + 左子树的前序遍历结果 + 右子树的前序遍历结果。
     * Java 的话无论 ArrayList 还是 LinkedList，addAll 方法的复杂度都是 O(N)，
     * 所以总体的最坏时间复杂度会达到 O(N^2)，除非你自己实现一个复杂度为 O(1) 的 addAll 方法，底层用链表的话并不是不可能。
     * @param root
     * @return
     */
    // 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
    public List<Integer> preorderTraverse2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse2(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraverse2(root.right));
        return res;
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
