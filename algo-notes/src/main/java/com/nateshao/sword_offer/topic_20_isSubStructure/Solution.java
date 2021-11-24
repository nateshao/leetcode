package com.nateshao.sword_offer.topic_20_isSubStructure;

/**
 * @date Created by 邵桐杰 on 2021/11/23 19:19
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 判断二叉树A中是否包含子树B
 */
class Solution {
    //    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (A == null) return true;
//        if (B == null) return true;
//
//    }
    public static void main(String[] args) {


    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public static boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
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
