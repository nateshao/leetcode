package com.nateshao.leetcode.code27_removeElement;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/10/8 11:20
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 双指针，
     * 快指针先走，如果num[fast]！=val ,就将值赋值给慢指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length==0)return 0;
        int slow=0,fast = 0;
        while (fast<nums.length){
            if (nums[fast]!=val){
               nums[slow] = nums[fast];
               slow++;
            }
            fast++;
        }
        return slow;
    }

}