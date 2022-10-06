package com.nateshao.sword_offer2.code_68_1;

/**
 * @date Created by 邵桐杰 on 2022/8/18 21:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class Solution {
    /**
     * 如果两个节点值都小于根节点，说明他们在根节点左子树上
     * 如果两个节点值都大于根节点，说明他们在根节点右子树上
     * 如果一个节点值大于根节点，一个节点值小于根节点，说明他们他们一个在根节点的左子树上一个在根节点的右子树上，
     * 那么根节点就是他们的最近公共祖先节点。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root.val >= p.val && root.val <= q.val)
            // p <= root <= q
            // 即 p 和 q 分别在 root 的左右子树，那么 root 就是 LCA
            return root;

        // p 和 q 都在 root 的左子树，那么 LCA 在左子树
        if (root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            // p 和 q 都在 root 的右子树，那么 LCA 在右子树
        else return lowestCommonAncestor(root.right, p, q);
    }

    /**
     * 方法二：递归
     * 递推工作：
     * 当 p, q 都在 root 的 右子树 中，则开启递归 root.right 并返回；
     * 否则，当 p,q 都在 root 的 左子树 中，则开启递归 root.left并返回；
     * 返回值： 最近公共祖先 root 。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > q.val && root.val > p.val) return lowestCommonAncestor2(root.left, p, q);
        if (root.val < q.val && root.val < p.val) return lowestCommonAncestor2(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < q.val && root.val < p.val) root = root.right;
            else if (root.val > q.val && root.val > p.val) root = root.left;
            else break;
        }
        return root;
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
