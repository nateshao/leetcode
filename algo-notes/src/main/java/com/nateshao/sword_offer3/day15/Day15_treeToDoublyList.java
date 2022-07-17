package com.nateshao.sword_offer3.day15;

/**
 * @date Created by 邵桐杰 on 2022/7/17 11:56
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day15_treeToDoublyList {
    /**
     * 中序遍历
     * 本文解法基于性质：二叉搜索树的中序遍历为 递增序列 。
     * 将 二叉搜索树 转换成一个 “排序的循环双向链表” ，其中包含三个要素：
     *
     * 排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点。
     * 双向链表： 在构建相邻节点的引用关系时，设前驱节点 pre 和当前节点 cur ，不仅应构建 pre.right = cur ，也应构建 cur.left = pre 。
     * 循环链表： 设链表头节点 head 和尾节点 tail ，则应构建 head.left = tail 和 tail.right = head 。
     * ----
     * 特例处理： 若节点 root 为空，则直接返回；
     * 初始化： 空节点 pre ；
     * 转化为双向链表： 调用 dfs(root) ；
     * 构建循环链表： 中序遍历完成后，head 指向头节点， pre 指向尾节点，因此修改 head 和 pre 的双向节点引用即可；
     * 返回值： 返回链表的头节点 head 即可；
     * @param root
     * @return
     */
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * dfs(cur): 递归法中序遍历；
     *
     * 终止条件： 当节点 cur 为空，代表越过叶节点，直接返回；
     * 递归左子树，即 dfs(cur.left) ；
     * 构建链表：
     * 当 pre 为空时： 代表正在访问链表头节点，记为 head ；
     * 当 pre 不为空时： 修改双向节点引用，即 pre.right = cur ， cur.left = pre ；
     * 保存 cur ： 更新 pre = cur ，即节点 cur 是后继节点的 pre ；
     * 递归右子树，即 dfs(cur.right) ；
     * @param cur
     */
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
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
