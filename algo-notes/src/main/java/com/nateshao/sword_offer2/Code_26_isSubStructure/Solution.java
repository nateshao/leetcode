package com.nateshao.sword_offer2.Code_26_isSubStructure;

/**
 * @date Created by 邵桐杰 on 2022/3/8 9:27
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * <p>
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
}
