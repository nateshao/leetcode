package com.nateshao.sword_offer.topic_20_isSubStructure;

/**
 * @date Created by 邵桐杰 on 2021/11/23 19:19
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 判断二叉树A中是否包含子树B
 */
class Solution {

    /**
     * 精选解答
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure1(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur1(A, B) || isSubStructure1(A.left, B) || isSubStructure1(A.right, B));
    }

    public static boolean recur1(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur1(A.left, B.left) && recur1(A.right, B.right);
    }

    /************************************** 法二 ********************************************/
    //遍历A的每一个节点
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;//约定空树不是任意一个树的子结构
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //同时遍历A和B的相同位置节点
    boolean recur(TreeNode A, TreeNode B) {
        //当B某个节点为null，则无需比较了，直接返回true，比较其他节点
        if (B == null) return true;
        //如果相同位置的两个节点不相同，则返回false，不用再继续比较了
        if (A == null || A.val != B.val) return false;
        //继续往下遍历比较
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
