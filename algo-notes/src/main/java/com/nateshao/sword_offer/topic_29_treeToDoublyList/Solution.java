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

    // 1. 中序，递归，来自解题大佬
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        // 边界值
        if(root == null) return null;
        dfs(root);

        // 题目要求头尾连接
        head.left = pre;
        pre.right = head;
        // 返回头节点
        return head;
    }
    void dfs(Node cur) {
        // 递归结束条件
        if(cur == null) return;
        dfs(cur.left);
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if (pre == null) head = cur;
            // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
            // 让上一个节点的右指针指向当前节点
        else if (pre != null) pre.right = cur;
        // 再让当前节点的左指针指向父节点，也就连成了双向链表
        cur.left = pre;
        // 保存当前节点，用于下层递归创建
        pre = cur;
        dfs(cur.right);
    }


    /**
     * 思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
     *
     * @param pRootOfTree
     * @return
     */
    public Node Convert(Node pRootOfTree) {
        Node lastlist = coverNode(pRootOfTree, null);
        Node pHead = lastlist;
        while (pHead != null && pHead.left != null) pHead = pHead.left;
        return pHead;

    }

    public Node coverNode(Node root, Node lastlist) {
        if (root == null) return null;
        Node cur = root;
        if (cur.left != null) coverNode(cur.left, lastlist);
        cur.left = lastlist;
        if (lastlist != null) lastlist.right = cur;
        lastlist = cur;
        if (cur.right != null) lastlist = coverNode(cur.right, lastlist);
        return lastlist;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
