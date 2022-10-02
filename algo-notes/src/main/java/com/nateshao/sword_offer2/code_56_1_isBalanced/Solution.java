package com.nateshao.sword_offer2.code_56_1_isBalanced;

/**
 * @date Created by 邵桐杰 on 2022/10/2 23:00
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 55 - II. 平衡二叉树
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left)
                && isBalanced(root.right)
                && Math.abs(maxDeth(root.left) - maxDeth(root.right)) <= 1;
    }

    private int maxDeth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDeth(root.left);
        int right = maxDeth(root.right);
        return Math.max(left, right) + 1;
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
