package com.nateshao.leetcode.code167_twoSum;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/10/8 10:35
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
       int left = 0,right = numbers.length-1;
       while (left<right){
           int sum = numbers[left]+numbers[right];
           if (sum==target)return new int[]{left+1,right+1};
           else if (sum<target)left++;
           else right--;
       }
       return new int[]{-1,-1};
    }

}