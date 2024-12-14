package com.nateshao.sword_offer2.Code_07_recur;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/18 11:27
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 1.找到一个根的index函数
     * 2.写出递归表达式
     * 3.写递归出口
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null; // 递归，边界的出口
        int index = findIndex(preorder, inorder);
        // 1. 找出树的根节点
        TreeNode root = new TreeNode(preorder[0]);
        // 2. 构建左右子树
        // root.left = buildTree(左子树的前序遍历，左子树的中序遍历)
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        // root.left = buildTree(右子树的前序遍历，右子树的中序遍历)
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    public int findIndex(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) return i;
        }
        return 0;
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