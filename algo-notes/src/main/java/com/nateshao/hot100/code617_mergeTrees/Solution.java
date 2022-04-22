package com.nateshao.hot100.code617_mergeTrees;

import com.nateshao.hot100.include.TreeNode;

/**
 * @date Created by 邵桐杰 on 2022/4/22 22:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：
 * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        // 合并根节点
        t1.val += t2.val;
        // 再递归合并左右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t2.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
