package com.nateshao.sword_offer2.Code_32_1_levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @date Created by 邵桐杰 on 2022/4/10 9:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];// 为空则返回空数组
        ArrayList<Integer> list = new ArrayList<>(); // 申请一个动态数组 ArrayList 动态添加节点值
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 根节点入队列
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();//取出当前队首元素
            list.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] =list.get(i);
//        }
//        return res;
        return list.stream().mapToInt(Integer::intValue).toArray();// 将 ArrayList 转为 int数组并返回




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
