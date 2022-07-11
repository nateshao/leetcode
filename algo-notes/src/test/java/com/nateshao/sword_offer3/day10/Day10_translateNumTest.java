package com.nateshao.sword_offer3.day10;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/7/10 21:32
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day10_translateNumTest {

    @Test
    public void translateNum() {
    }

    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}