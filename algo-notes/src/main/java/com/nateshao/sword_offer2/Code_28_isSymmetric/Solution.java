package com.nateshao.sword_offer2.Code_28_isSymmetric;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/3/8 10:14
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return (root == null) ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(R.left, L.right);
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] res = new int[10];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = sc.nextInt();
//        }
//        for (int re : res) {
//            System.out.print(re + " ");
//        }
//    }
}
