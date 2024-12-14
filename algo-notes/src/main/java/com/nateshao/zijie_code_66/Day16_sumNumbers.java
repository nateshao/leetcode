package com.nateshao.zijie_code_66;

/**
 * @date Created by 邵桐杰 on 2022/3/23 11:17
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 */
public class Day16_sumNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        childSum(0, root);
        return sum;
    }

    private void childSum(int val, TreeNode root) {
        if (root == null) return;
        int k = (val * 10 + root.val);
        if (root.left == null && root.right == null) {
            sum += k;
        }
        childSum(k, root.left);
        childSum(k, root.right);
    }


    /**
     * labuladong
     * 让我获取所有路径数字之和，那我递归遍历一遍二叉树，沿路记录下来路径上的数字，
     * 到叶子节点的时候求和，不就完事了？
     */
    StringBuilder path = new StringBuilder();
    int res = 0;

    public int sumNumbers1(TreeNode root) {
        // 遍历一遍二叉树就能出结果
        traverse(root);
        return res;
    }

    /**
     * 二叉树遍历函数
     *
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) return;
        // 前序遍历位置，记录节点值
        path.append(root.val);

        if (root.left == null && root.right == null) {
            // 到达叶子节点，累加路径和
            res += Integer.parseInt(path.toString());
        }
        // 二叉树递归框架，遍历左右子树
        traverse(root.left);
        traverse(root.right);
        // 后续遍历位置，撤销节点值
        path.deleteCharAt(path.length() - 1);
    }

    /**
     * Definition for a binary tree node.
     */
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
