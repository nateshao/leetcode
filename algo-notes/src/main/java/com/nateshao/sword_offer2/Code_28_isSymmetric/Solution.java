package com.nateshao.sword_offer2.Code_28_isSymmetric;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/3/8 10:14
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 对称二叉树定义： 对于树中 任意两个对称节点 L 和 R ，一定有：
     * L.val = R.val ：即此两对称节点值相等。
     * L.left.val = R.right.val：即 L 的 左子节点 和 R 的 右子节点 对称；
     * L.right.val = R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return (root == null) ? true : recur(root.left, root.right);
    }

    /**
     * 当 L 和 R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true ；
     * 当 L 或 R 中只有一个越过叶节点： 此树不对称，因此返回 false ；
     * 当节点 L 值 != 节点 R 值： 此树不对称，因此返回 false ；
     *
     * @param L
     * @param R
     * @return
     */
    public boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(R.left, L.right);
    }


}
