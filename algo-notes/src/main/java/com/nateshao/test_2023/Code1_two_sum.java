package com.nateshao.test_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 两数之和：https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
 */
public class Code1_two_sum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}

