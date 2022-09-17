package com.nateshao.sword_offer.topic_26_verifyPostorder;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2021/11/30 14:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 二叉搜索树的后序遍历序列
 */
public class Solution {
    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        int[] postorder2 = {1, 6, 3, 2, 5};// false
        int[] postorder3 = {1, 6, 3, 2, 5};// false
        System.out.println("递归：(postorder) = " + verifyPostorder(postorder));
        System.out.println("递归：(postorder2) = " + verifyPostorder(postorder2));
        System.out.println("栈：(postorder3) = " + verifyPostorder2(postorder3));
    }

    /**
     * 递归
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public static boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
    /**
     * 方法二：栈
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        //初始化： 单调栈 stack ，父节点值 root = +∞ （初始值为正无穷大，可把树的根节点看为此无穷大节点的左孩子）；
        int root = Integer.MAX_VALUE;
        // 倒序遍历 postorder：记每个节点为 i
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 若 ri>root，说明此后序遍历序列不满足二叉搜索树定义，直接返回 false ；
            if (postorder[i] > root) return false;
            // 更新父节点root：当栈不为空且 stack.peek()>ri时，循环执行出栈，并将出栈节点赋给 root
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]); // 入栈： 将当前节点 ri
        }
        return true; //遍历完成，则说明后序遍历满足二叉搜索树定义，返回 true 。
    }
    /**
     * 递归：(postorder) = true
     * 递归：(postorder2) = false
     * 栈：(postorder3) = false
     */
}


