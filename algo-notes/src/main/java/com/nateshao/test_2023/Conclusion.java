package com.nateshao.test_2023;

/**
 * @date Created by 邵桐杰 on 2023/2/11 11:48
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Conclusion {
    public static void main(String[] args) {

    }

    // 数组遍历
    void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

        }
    }

    // 链表遍历：1.迭代；2.递归
    // 1.迭代
    void listNodeTraverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代访问p.val
        }
    }

    // 递归访问
    void diguiTraverse(ListNode head) {
        diguiTraverse(head.next);
    }

    class ListNode {
        int val;
        ListNode next;
    }

    // 二叉树遍历。1.递归
    class TreeNode{
        int val;
        TreeNode left,right;
    }
    void traverse(TreeNode root){
        traverse(root.left);
        traverse(root.right);
    }

}
