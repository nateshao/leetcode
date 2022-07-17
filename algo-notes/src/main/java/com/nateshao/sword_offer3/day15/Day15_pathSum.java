package com.nateshao.sword_offer3.day15;

import java.util.LinkedList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/7/17 11:09
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 */
public class Day15_pathSum {
    /**
     * 先序遍历 + 路径记录
     * <p>
     * 算法流程：
     * pathSum(root, sum) 函数：
     * <p>
     * 初始化： 结果列表 res ，路径列表 path 。
     * 返回值： 返回 res 即可。
     * recur(root, tar) 函数：
     * <p>
     * 递推参数： 当前节点 root ，当前目标值 tar 。
     * 终止条件： 若节点 root 为空，则直接返回。
     * 递推工作：
     * 路径更新： 将当前节点值 root.val 加入路径 path ；
     * 目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 00 ）；
     * 路径记录： 当 ① root 为叶节点 且 ② 路径和等于目标值 ，则将此路径 path 加入 res 。
     * 先序遍历： 递归左 / 右子节点。
     * 路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。
     *
     * @param root
     * @param target
     * @return
     */
    LinkedList<List<Integer>> res = new LinkedList<>(); // 存放结果
    LinkedList<Integer> path = new LinkedList<>(); // 记录路径
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    /**
     * 先序遍历
     * @param root
     * @param target
     */
    private void recur(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) res.add(new LinkedList<>(path));
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }

    public class TreeNode {
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
