package com.nateshao.sword_offer2.Code_27_mirrorTree;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 22:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(node);
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode rootLeft = mirrorTree2(root.left);
        TreeNode rootRight = mirrorTree2(root.right);
        root.right = rootLeft;
        root.left = rootRight;
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