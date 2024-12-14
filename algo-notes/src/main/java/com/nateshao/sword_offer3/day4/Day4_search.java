package com.nateshao.sword_offer3.day4;

import java.util.ArrayList;

/**
 * @date Created by 邵桐杰 on 2022/5/29 20:55
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class Day4_search {
    /**
     * 自己想的：
     * 遍历一遍数组，如果nums[i] == target,res++
     * 返回res
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            }
        }
        return res;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            if (nums[mid] < target) {
                low=mid+1;
            }else if (nums[mid]>target){
                hight=mid-1;
            }else {
                if (nums[low]==nums[hight]){
                    return hight-low+1;
                }else if (nums[low]<target){
                    low++;
                }else {
                    hight--;
                }
            }
        }
        return 0;
    }

}











