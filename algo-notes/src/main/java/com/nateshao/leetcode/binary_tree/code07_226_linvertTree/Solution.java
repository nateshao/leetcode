package com.nateshao.leetcode.binary_tree.code07_226_linvertTree;

/**
 * @date Created by 邵桐杰 on 2022/4/25 11:01
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/invert-binary-tree/
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 */
public class Solution {
    /**
     * 利用前序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
    }
    /**
     * 利用后序遍历
     * @param root
     * @return
     */
        public TreeNode invertTree2(TreeNode root) {
            // 后序遍历-- 从下向上交换
            if (root == null) return null;
            TreeNode leftNode = invertTree2(root.left);
            TreeNode rightNode = invertTree2(root.right);
            root.right = leftNode;
            root.left = rightNode;
            return root;
        }
    /************** labuladong ****************/


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
