package com.nateshao.sword_offer2.code_57_twoSum;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/10/2 23:39
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else return new int[]{nums[left], nums[right]};
        }
        return null;
    }

}