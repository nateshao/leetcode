package com.nateshao.test.test2025.inorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    }
    LinkedList<Integer> res = new LinkedList<>();

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

}
