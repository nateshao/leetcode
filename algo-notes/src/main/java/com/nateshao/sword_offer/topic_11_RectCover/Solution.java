package com.nateshao.sword_offer.topic_11_RectCover;

/**
 * @date Created by 邵桐杰 on 2021/11/20 11:26
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        int rectCover = rectCover(3);
        System.out.println("rectCover = " + rectCover);
        int rectCover2 = rectCover2(3);
        System.out.println("rectCover2 = " + rectCover2);
    }

    public static int rectCover(int target) {
        if (target <= 0) return 0;
        else if (target <= 2) return target;
        else return rectCover(target - 1) + rectCover(target - 2);
    }

    public static int rectCover2(int target) {
        int a = 1, b = 2, sum = 0;
        if (target == 0) return 0;
        if (target <= 2) return target;
        for (int i = 3; i <= target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
