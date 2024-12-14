package com.nateshao.sword_offer.topic_42_isBalanced;

/**
 * @date Created by 邵桐杰 on 2022/1/23 19:26
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    //    public boolean isBalanced(TreeNode root){
//        if(root == null) {
//            return true;
//        }
//        boolean condition = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
//        return condition && isBalanced(root.left) && isBalanced(root.right);
//    }
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        return Math.max(left, right) + 1;
//    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
