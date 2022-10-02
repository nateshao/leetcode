package com.nateshao.sword_offer2.code_54_kthLargest;

/**
 * @date Created by 邵桐杰 on 2022/10/2 20:09
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class Solution {
    int res = 0, count = 0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    /**
     * 注意是第 K 大，所以右根左；第K小才是左根右
     * @param root
     * @param k
     */
    private void dfs(TreeNode root, int k) {
        if (root.right != null) dfs(root.right, k);
        if (k == count++) {
            res = root.val;
            return;
        }
        if (root.left != null) dfs(root.left, k);
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
