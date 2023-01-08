package com.nateshao.test_2022.test_09_15;

/**
 * @date Created by 邵桐杰 on 2022/9/15 14:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 给定一个二叉树，
 * <p>
 * 1
 * 2     3
 * 4  5   6  7
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root = root1;
        root.left = root2;
        root.right = root3;
        root1.left = root4;
        root1.right = root5;
        root2.left = root6;
        root2.right = root7;
        TreeNode num = getNum(root, root4, root5);
        System.out.println(num.val);
    }

    /**
     * 二叉树的最近公共子先
     * 递归左右节点，返回左右节点
     *     1
     *  2     3
     *4  5   6  7
     * @param rootA
     * @param rootB
     * @return
     */
    public static TreeNode getNum(TreeNode root, TreeNode rootA, TreeNode rootB) {
        if (root == null) return null;
        if (root == rootA || root == rootB)return root;
        TreeNode left = getNum(root.left, rootA, rootB);
        TreeNode right = getNum(root.right, rootA, rootB);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
