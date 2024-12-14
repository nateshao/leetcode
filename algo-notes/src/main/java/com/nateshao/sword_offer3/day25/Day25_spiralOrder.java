package com.nateshao.sword_offer3.day25;

/**
 * @date Created by 邵桐杰 on 2022/7/24 10:20
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Day25_spiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        // l：左       r：右         t：上         b：下
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //从左往右
            //列在变，列为循环值
            //从左往右的下一步是往下走，上边界内缩，故++t
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if (++t > b) break;
            //从上往下，行在变
            //从上往下的下一步是从右往左，右边界收缩，--r
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if (l > --r) break;
            //从右向左，列在变
            //从右往左的下一步是从下往上，下边界收缩，--b
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if (t > --b) break;
            //从下到上，行在变
            //从下到上的下一步是从左到右，左边界收缩，++l
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }
}
