package com.nateshao.sword_offer2.Code_03_findRepeatNumber;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/17 22:46
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int number = findRepeatNumber(nums);
        System.out.println("number = " + number);
    }
    /**
     * 通过hashset实现
     * 遍历数组，如果hashset含有，就返回，
     * 没有就添加到hashset里面
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))return num;
            set.add(num);
        }
        return -1;
    }

}