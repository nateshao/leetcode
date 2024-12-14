package com.nateshao.hot100.code_two_pointers.code1_141_hasCycle;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2023/1/7 23:15
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,4,6,3,2,2,2,2,2,};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println("repeatNumber = " + repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))return num;
            set.add(num);
        }
        return -1;
    }

}