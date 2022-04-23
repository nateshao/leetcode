package com.nateshao.nowcoder_top101.binary_tree.BM25_postorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/4/23 11:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    List<Integer> res = new ArrayList<>();
    public int[] postorderTraversal(TreeNode root) {
        // write code here
        if (root == null) return new int[0];
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
//        int[] ints = new int[res.size()];
//        for (int i = 0; i < ints.length; i++) {
//           ints[i] =res.get(i);
//        }
//        return ints;
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
