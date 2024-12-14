package com.nateshao.sword_offer2.code_68_2;

/**
 * @date Created by 邵桐杰 on 2022/8/18 21:22
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 */
public class Solution {
    /**
     * 递归
     * 1. p,q分散在两侧，则root节点为最近公共祖先 （root可以为任意不为null节点）
     * 2. p,q在同一侧，此时要么二者其中之一为最近公共祖先，要么回到 1.
     * （即搜索到了p或者q就可直接向上返回,此时有：
     * 1. 搜索其它分支找不到另一节点q（假设p被找到了），则p是最近公共祖先
     * 2. 搜索其它分支找到了q，则此时回到情况1 ）
     * 方法目的：在root为根节点的情况下，找到p,q的最近公共祖先
     * 结束条件：当传入的节点为null,或者找到其中一个节点时
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;  // p,q分散在两侧时，right和left都不为null,root即为答案
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
