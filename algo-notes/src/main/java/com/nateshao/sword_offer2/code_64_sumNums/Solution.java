package com.nateshao.sword_offer2.code_64_sumNums;

/**
 * @date Created by 邵桐杰 on 2022/10/3 17:35
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    int res = 0;
    public int sumNums2(int n) {
        boolean x = n > 1 && sumNums2(n - 1) > 0;
        res += n;
        return res;
    }

}