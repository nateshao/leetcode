package com.nateshao.sword_offer3.day15;

/**
 * @date Created by 邵桐杰 on 2022/7/18 22:46
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 */
public class Day15_kthLargest {
    /**
     * 二叉搜索树的中序遍历为 递增序列
     * 根据以上性质，易得二叉搜索树的 中序遍历倒序 为 递减序列 。
     * 因此，求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”。
     *
     * @param root
     * @param k
     * @return
     */
    int ans = 0, count = 0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root.right != null) dfs(root.right, k);
        if (++count == k) {
            ans = root.val;
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
