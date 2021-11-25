package com.nateshao.sword_offer.topic_21_mirrorTree;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2021/11/24 22:48
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 27. 二叉树的镜像
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(node);
        return root;
    }


    /**
     * 解法一：递归，时间复杂度：O(n)，空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;

        return leftNode.val == rightNode.val && isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
    }

    /**
     * 解法二：迭代，时间复杂度：O(n)，空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);
        }
        return true;
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
