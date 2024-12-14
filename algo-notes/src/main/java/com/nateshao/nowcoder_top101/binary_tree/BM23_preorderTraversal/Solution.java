package com.nateshao.nowcoder_top101.binary_tree.BM23_preorderTraversal;

import java.util.*;

/**
 * @date Created by 邵桐杰 on 2022/4/23 10:27
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: BM23 二叉树的前序遍历
 */


public class Solution {
    /**
     * 牛客网
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    List<Integer> list = new LinkedList<>();
    public int[] preorderTraversal(TreeNode root) {
        traverse2(root);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;

        // return list.stream().mapToInt(Integer::intValue).toArray(); // 采用java8的stream()
    }

    void traverse2(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        traverse2(root.left);
        traverse2(root.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /******************  leetcode *****************/
    /* 回溯算法思路 */
    List<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) return;
        // 前序遍历位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
