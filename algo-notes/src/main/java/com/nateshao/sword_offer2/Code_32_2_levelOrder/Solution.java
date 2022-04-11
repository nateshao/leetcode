package com.nateshao.sword_offer2.Code_32_2_levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date Created by 邵桐杰 on 2022/4/11 9:23
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Solution {
    /**
     * 算法流程：
     * 特例处理： 当根节点为空，则返回空列表 [] ；
     * 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
     * BFS 循环： 当队列 queue 为空时跳出；
     *      新建一个临时列表 tmp ，用于存储当前层打印结果；
     *      当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
     *          出队： 队首元素出队，记为 node；
     *          打印： 将 node.val 添加至 tmp 尾部；
     *          添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
     *  将当前层结果 tmp 添加入 res 。
     * 返回值： 返回打印结果列表 res 即可。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();//打印结果
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();// 新建一个临时列表 tmp ，用于存储当前层打印结果；
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
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
