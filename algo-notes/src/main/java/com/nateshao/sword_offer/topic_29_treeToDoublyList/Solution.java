package com.nateshao.sword_offer.topic_29_treeToDoublyList;

/**
 * @date Created by 邵桐杰 on 2021/12/2 15:31
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 二叉搜索树与双向链表
 */
public class Solution {

    public Node treeToDoublyList(Node root) {


    }



    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

}
