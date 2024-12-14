package com.nateshao.sword_offer2.code_55_maxDepth;

/**
 * @date Created by 邵桐杰 on 2022/8/4 22:28
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int MaxLeft = maxDepth2(root.left);
        int MaxRight = maxDepth2(root.right);
        return Math.max(MaxLeft, MaxRight) + 1;
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
