package com.nateshao.hot100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @date Created by 邵桐杰 on 2023/2/11 13:29
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class Code1_twoSum {
    /**
     * hashmap
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (res.containsKey(need)) return new int[]{res.get(need), i};
            res.put(nums[i], i);
        }
        return null;
    }

    /**
     * 排序+双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else if (sum==target) {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
