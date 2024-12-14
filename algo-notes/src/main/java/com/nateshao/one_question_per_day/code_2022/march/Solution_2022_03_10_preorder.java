package com.nateshao.one_question_per_day.code_2022.march;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/3/10 9:48
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution_2022_03_10_preorder {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            helper(child,res);
        }
    }


    /**
     * 迭代-栈
     * @param
     * @return
     */
//    public List<Integer> preorder2(Node root) {
//
//
//    }
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
}
