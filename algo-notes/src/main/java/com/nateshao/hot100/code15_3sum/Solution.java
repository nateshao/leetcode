package com.nateshao.hot100.code15_3sum;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2023/1/24 23:34
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/3sum/
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class Solution {

    /**
     * 双指针
     * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于0,直接返回结果。
     * 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：
     * 因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int target = nums[left] + nums[right] + nums[i];
                if (target > 0) {
                    while (left < right && nums[right] == nums[--right]) ;
                } else if ((target < 0)) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[--right]) ;
                    while (left < right && nums[left] == nums[++left]) ;
                }
            }
        }
        return res;
    }
}
