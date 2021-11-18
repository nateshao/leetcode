package com.nateshao.sword_offer.topic_06_buildTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2021/11/17 10:48
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 重建二叉树
 */
public class Solution {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
    }
    /**
     * 思路：先找出根节点，然后利用递归方法构造二叉树
     * 代码实现：时间复杂度：O(n)，空间复杂度：O(n)
     * 解法一：递归（传入数组的拷贝）
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1,
                        i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,
                        i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }


//    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
//    int[] preorder;//保留的先序遍历，方便递归时依据索引查看先序遍历的值
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        this.preorder = preorder;
//        //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        //三个索引分别为
//        //当前根的的索引
//        //递归树的左边界，即数组左边界
//        //递归树的右边界，即数组右边界
//        return recur(0, 0, inorder.length - 1);
//    }
//
//    TreeNode recur(int pre_root, int in_left, int in_right) {
//        if (in_left > in_right) return null;// 相等的话就是自己
//        TreeNode root = new TreeNode(preorder[pre_root]);//获取root节点
//        int idx = map.get(preorder[pre_root]);//获取在中序遍历中根节点所在索引，以方便获取左子树的数量
//        //左子树的根的索引为先序中的根节点+1
//        //递归左子树的左边界为原来的中序in_left
//        //递归左子树的右边界为中序中的根节点索引-1
//        root.left = recur(pre_root + 1, in_left, idx - 1);
//        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
//        //递归右子树的左边界为中序中当前根节点+1
//        //递归右子树的右边界为中序中原来右子树的边界
//        root.right = recur(pre_root + (idx - in_left) + 1, idx + 1, in_right);
//        return root;
//    }

    /**
     * 官方题解
     * 时间复杂度：O(n)，其中 nn 是树中的节点个数。
     *
     * 空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，
     * 我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。
     * 这里 h < n，所以总空间复杂度为 O(n)。
     */
    private Map<Integer, Integer> indexMap;
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
