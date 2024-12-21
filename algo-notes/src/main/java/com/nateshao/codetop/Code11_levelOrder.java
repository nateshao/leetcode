package com.nateshao.codetop;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code11_levelOrder {
    /**
     * 102. 二叉树的层序遍历
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
     * <p>
     * 思路：
     * 算法流程：
     * 特例处理： 当根节点为空，则返回空列表 [] 。
     * 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] 。
     * BFS 循环： 当队列 queue 为空时跳出。
     * 新建一个临时列表 tmp ，用于存储当前层打印结果。
     * 当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）。
     * 出队： 队首元素出队，记为 node。
     * 打印： 将 node.val 添加至 tmp 尾部。
     * 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue 。
     * 将当前层结果 tmp 添加入 res 。
     * 返回值： 返回打印结果列表 res 即可。
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal/solutions/2361604/102-er-cha-shu-de-ceng-xu-bian-li-yan-du-dyf7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);                            // while 循环控制从上向下一层层遍历
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();// 记录这一层的节点值
            for (int i = 0; i < queue.size(); i++) { // for 循环控制每一层从左向右遍历
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
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
