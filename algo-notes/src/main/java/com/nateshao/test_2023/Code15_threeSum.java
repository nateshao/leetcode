package com.nateshao.test_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2023/1/8 15:41
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Code15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// 先排序，形成一个递增的数组
        List<List<Integer>> res = new ArrayList<>();
        // k < nums.length - 2是为了保证后面还能存在两个数字
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;// 若nums[k]大于0，则后面的数字也是大于零（排序后是递增的）
            if (k > 0 && nums[k] == nums[k - 1]) continue; // nums[k]值重复了，去重
            // 定义左右指针
            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ; // 左指针前进并去重
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]); // 右指针后退并去重
                } else {
                    res.add(Arrays.asList(nums[k], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) ; // 左指针前进并去重
                    while (left < right && nums[right] == nums[--right]) ; // 右指针后退并去重
                }
            }
        }
        return res;
    }
}
