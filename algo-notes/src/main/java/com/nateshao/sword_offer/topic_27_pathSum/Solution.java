package com.nateshao.sword_offer.topic_27_pathSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/1 16:45
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 二叉树中和为某一值的路径
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        Solution p = new Solution();
        System.out.println(p.listAll);
        p.pathSum(node1, 22);
        for (List<Integer> list : p.listAll) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        /**
         * []
         * 10 5 7
         * 10 12
         */
    }

    /****************************************************************/

    private static List<List<Integer>> listAll = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    /**
     * 思路：先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值
     *
     * @param root
     * @param target
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        pathSum(root.left, target);
        pathSum(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }


    /*********************** 精选解答 ***************************/
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
