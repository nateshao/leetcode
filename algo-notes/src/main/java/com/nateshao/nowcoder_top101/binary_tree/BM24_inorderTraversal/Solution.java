package com.nateshao.nowcoder_top101.binary_tree.BM24_inorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/4/23 11:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://www.nowcoder.com/practice/0bf071c135e64ee2a027783b80bf781d?tpId=295&tqId=1512964&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295
 * BM24 二叉树的中序遍历
 */
public class Solution {

    /**
     * 牛客网
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 递归法
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    /* 回溯算法思路 */
    List<Integer> res = new LinkedList<>();
    // 返回前序遍历结果
    public int[] inorderTraversal(TreeNode root) {
        traverse(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
