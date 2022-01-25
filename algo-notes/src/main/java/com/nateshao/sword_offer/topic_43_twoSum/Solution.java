package com.nateshao.sword_offer.topic_43_twoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/1/25 8:23
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.println("i1 = " + i);
        }

        int[] twoSum2 = twoSum2(nums, target);
        for (int i : twoSum2) {
            System.out.println("i2 = " + i);
        }
        int[] twoSum3 = twoSum3(nums, target);
        for (int i : twoSum3) {
            System.out.println("i3 = " + i);
        }

    }

    /**
     * HashSet O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Set<Object> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(target - num)) {
                set.add(num);
            } else {
                return new int[]{num, target - num};
            }
        }
        return new int[]{};
    }

    /**
     * 双指针 O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int cur = nums[left] + nums[right];
            if (cur == target) return new int[]{nums[left] , nums[right]};
            else if (cur > target) right--;
            else left++;
        }
        return new int[]{};
    }

    /**
     * HashMap
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }

        int[] result = new int[2];
        for (int num : nums) {
            int value =  hashMap.getOrDefault((target-num),-1);
            // System.out.println("key Three 对应的 value: " + value);
            if (value!= -1 && value != hashMap.get(num)) {
                result[0] = num;
                result[1] = target-num;
            }
        }
        return result;
    }
}
