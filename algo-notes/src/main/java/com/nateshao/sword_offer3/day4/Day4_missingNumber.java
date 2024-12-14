package com.nateshao.sword_offer3.day4;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/5/29 22:56
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Day4_missingNumber {
    public int missingNumber(int[] nums) {
        // 理论的和减去实际的和即为缺少的数字
        //计算出0-n的和  n*(n+1)/2
        int sum = nums.length * (nums.length + 1) / 2;
        return sum - Arrays.stream(nums).sum();

    }


    /**
     * 虽然是O(N)但我感觉这个看着好舒服啊
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return nums.length;
    }

    /**
     * 二分
     *
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

}
