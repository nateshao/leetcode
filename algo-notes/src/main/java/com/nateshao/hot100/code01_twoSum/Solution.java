package com.nateshao.hot100.code01_twoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @date Created by 邵桐杰 on 2022/4/20 9:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("-------");
    }
    /**
     * 第一种解法：暴力求解，两层for循环
     * 运行结果：通过，速度击败 30%
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * hashmap
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum3(int[] nums, int target) {
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            int cur = nums[left] + nums[right];
//            if (cur == target) return new int[]{left, right};
//            else if (cur > target) right--;
//            else left++;
//        }
//        return new int[];
//
//    }


}
