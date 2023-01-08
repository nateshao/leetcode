package com.nateshao.test_2023;

/**
 * @date Created by 邵桐杰 on 2023/1/8 17:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class Code11_maxArea {
    /**
     * 双指针
     * 双指针由左边向中间靠拢
     * 面积 = Math.min(height[left],height[right]) * (right-left);
     * 定义双指针，while（left<right）
     * 定义结果集 int res = 0;
     * 取结果集 res = Math.max(res,面积)
     * if（height[left]<height[right]）{
     * left++;
     * }else{
     * right--;
     * }
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur_area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
