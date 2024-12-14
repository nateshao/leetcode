package com.nateshao.one_question_per_day.code_2022.april;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/4/8 16:56
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 */
public class Solution_2022_04_08_levelOrder {


    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (root != null) {
            int cnt = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                Node cur = queue.poll();
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
