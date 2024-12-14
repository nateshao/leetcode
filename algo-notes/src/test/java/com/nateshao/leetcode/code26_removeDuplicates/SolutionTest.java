package com.nateshao.leetcode.code26_removeDuplicates;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/10/8 10:39
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 定义快慢指针
     * 快指针走一步
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)return 0;
        int slow = 0,fast = 0;
        while (fast<nums.length){
            if (nums[slow]!=nums[fast]){
                // 慢指针++
                // 维护滑动窗口,将快指针的值，赋值给慢指针
                slow++;
               nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

}