package com.nateshao.sword_offer2.Code_33_verifyPostorder;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/4/12 15:27
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class Solution {
    /**
     * 方法1：辅助单调栈
     * <p>
     * 后序遍历:1,3,2,6,5
     * 后续遍历倒序：5，6，2，3，1
     * <p>
     * 初始化： 单调栈 stack ，父节点值 root = +∞ （初始值为正无穷大，可把树的根节点看为此无穷大节点的左孩子）；
     * 倒序遍历 postorder：记每个节点为 i
     * 若 ri>root，说明此后序遍历序列不满足二叉搜索树定义，直接返回 false ；
     * 更新父节点root：当栈不为空且 stack.peek()>ri时，循环执行出栈，并将出栈节点赋给 root
     * 入栈： 将当前节点 ri
     * //遍历完成，则说明后序遍历满足二叉搜索树定义，返回 true 。
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;// 若 ri>root ，说明此后序遍历序列不满足二叉搜索树定义，直接返回 false ；
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);// 将当前节点 ri 入栈；
        }
        return true;// 若遍历完成，则说明后序遍历满足二叉搜索树定义，返回true 。
    }

    /**
     * 递归
     * @param postorder
     * @return
     */
    public boolean verifyPostorder2(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;// 说明此子树节点数量 ≤ 1 ，无需判别正确性，因此直接返回 true ；
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
