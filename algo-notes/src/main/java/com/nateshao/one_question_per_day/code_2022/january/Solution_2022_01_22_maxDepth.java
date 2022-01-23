package com.nateshao.one_question_per_day.code_2022.january;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date Created by 邵桐杰 on 2022/1/22 22:56
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution_2022_01_22_maxDepth {

    /**
     * 方法一：递归解法
     * 思路：利用递归遍历分别返回左右子树深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
//        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right) + 1);
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 方法二：层序遍历（BFS）
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
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
