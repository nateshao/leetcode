package com.nateshao.hot100;

/**
 * @date Created by 邵桐杰 on 2023/2/9 21:29
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 581. 最短无序连续子数组
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 */
public class Code581_findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[nums.length - 1];
        int max = nums[0];
        int begin = 0, end = -1;
        //遍历
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) end = i;  //从左到右维持最大值，寻找右边界end
            else max = nums[i];

            if (nums[len - i - 1] > min) begin = len - i - 1;   //从右到左维持最小值，寻找左边界begin
            else min = nums[len - i - 1];
        }
        return end - begin + 1;
    }
}
