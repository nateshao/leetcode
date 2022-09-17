package com.nateshao.sword_offer.topic_31_majorityElement;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/12/5 17:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数
 * 字。如果不存在则输出 0。
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i1 = majorityElement1(arr);
        int i2 = majorityElement2(arr);
        int i3 = majorityElement3(arr);
        System.out.println("i = " + i1); // i = 2
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);

    }
    /******************** 精选 *********************/
    public static int majorityElement1(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;// votes = votes + ( num == x ? 1 : -1);
        }
        return x;
    }
    /**************** 拓展 *********************/
    public int majorityElement11(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }
    /****************** 剑指offer **********************/
    /**
     * 思路：将首次出现的数 count+1，与之后的数进行比较，相等则+1，否则—1，
     * 最后进行校验是否超过长度的一半。
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return checkMoreThanHalf(nums, candidate) ? candidate : 0;
    }

    private static boolean checkMoreThanHalf(int[] array, int number) {
        int times = 0;
        for (int i : array) {
            if (i == number) times++;
        }
        return times * 2 >= array.length;
    }


    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
