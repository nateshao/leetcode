package com.nateshao.sword_offer.topic_26_verifyPostorder;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/11/30 14:22
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        int[] postorder2 = {1, 6, 3, 2, 5};
        System.out.println("verifyPostorder(postorder) = " + verifyPostorder(postorder));
        System.out.println("verifyPostorder(postorder2) = " + verifyPostorder(postorder2));
    }


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
     * verifyPostorder(postorder) = true
     * verifyPostorder(postorder2) = false
     */
}


