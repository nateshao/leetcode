package com.nateshao.sword_offer3.day7;

/**
 * @date Created by 邵桐杰 on 2022/7/5 10:12
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class Day7_isSymmetric {
    /**
     * 解题思路：
     * 对称二叉树定义： 对于树中 任意两个对称节点 L 和 R ，一定有：
     * L.val = R.val ：即此两对称节点值相等。
     * L.left.val = R.right.val ：即 L 的 左子节点 和 R 的 右子节点 对称；
     * L.right.val = R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
     *
     * @param root
     * @return 如果root为null ，返回true
     * 返回：递归 root.left, root.right
     */
    public boolean isSymmetric(TreeNode root) {
        // 若根节点 root 为空，则直接返回 true。
        if (root == null) return true;
        // 检查两棵子树是否对称
        return recur(root.left, root.right);
    }

    /**
     * 1.如果left ==null || right ==null ; return true
     * 2. 如果left == null || right == null || left.val != right.val 返回false
     * 3. 返回递归：
     *
     * @param L
     * @param R
     * @return
     */
    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        // 两个根节点需要相同
        if (L == null || R == null || L.val != R.val) return false;
        // 左右子节点需要对称相同
        return recur(L.left, R.right) && recur(L.right, R.left); //同时成立
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
