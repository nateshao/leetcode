package com.nateshao.sword_offer3.day18;

/**
 * @date Created by 邵桐杰 on 2022/7/20 10:11
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Day18_isBalanced {
    /**
     * 是否平衡，
     * 1，获取二叉树的深度（深度优先遍历-递归）
     * 2，如果左右最大深度大于 1，就不是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    boolean isBalanced = true;
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 递归遍历左右子树
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        if (Math.abs((leftMaxDepth - rightMaxDepth)) > 1) {
            isBalanced = false;
        }
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
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
