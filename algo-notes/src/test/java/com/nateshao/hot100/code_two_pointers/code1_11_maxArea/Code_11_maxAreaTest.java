package com.nateshao.hot100.code_two_pointers.code1_11_maxArea;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/16 9:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Code_11_maxAreaTest {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1, res = 0;
        while (left < right) {
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(cur_area, res);
            if (height[left]<height[right])left++;
            else right--;
        }
        return res;
    }

}