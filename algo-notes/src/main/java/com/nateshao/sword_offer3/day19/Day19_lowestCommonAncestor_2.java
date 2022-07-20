package com.nateshao.sword_offer3.day19;

/**
 * @date Created by 邵桐杰 on 2022/7/20 16:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day19_lowestCommonAncestor_2 {
    /**
     * 二叉树的最近公共祖先
     * 思路：
     * 三种情况：
     * 1，如果 p 和 q 都在以 root 为根的树中，那么 left 和 right 一定分别是 p 和 q（从 base case 看出来的）。
     * 2，如果 p 和 q 都不在以 root 为根的树中，直接返回 null。
     * 3，如果 p 和 q 只有一个存在于 root 为根的树中，函数返回该节点。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况 1
        if (left != null && right != null) return root;
        // 情况 2：p 和 q 都不在以 root 为根的树中，直接返回 null。
        if (left == null && right == null) return null;
        // 情况 3：p 和 q 只有一个存在于 root 为根的树中，函数返回该节点。
        return left == null ? right : left;
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
