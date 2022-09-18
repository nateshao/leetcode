package com.nateshao.sword_offer2.Code_11_minArray;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/18 21:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 二分查找
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
//        Arrays.sort(numbers);
//        return numbers[0];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else right--;
        }
        return numbers[left];
    }


}