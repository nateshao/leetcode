package com.nateshao.leetcode.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2021/11/3 15:11
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 删除有序数组的重复项  26
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * <p>
 * 思路：
 * 我把本题归结为快慢指针的问题，慢指针是指向所有不重复的元素，快指针指的是所有的元素，
 * 当数组中没有重复元素的时候，他们是相同的，指针的话我一般喜欢用while循环，
 * 自己控制指针在什么情况下才自增。
 *
 * https://blog.csdn.net/YouMing_Li/article/details/114226853
 */
public class Remove_Repeat_Array_26 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 2, 3, 4, 5, 76, 89, 22};
//        removeDuplicates1(nums);
        removeDuplicates1(nums);
//        removeDuplicates1(nums);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 分析
     * 快慢指针的妙用，利用两个指针i, j,初始化值为0和1，当两个指针对应的值相等时，指针j+1，继续执行循环；
     * 而当两个指针对应的值不相等时，将指针i+1，并将指针j对用的值赋值给指针i，然后指针j+1，继续向下执行循环，直到循环结束。
     * <p>
     * 细节需要注意：最后慢指针是最后一个数据的索引，题目要求是返回数组的长度，所以需要 +1返回；
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    /**
     * hash表
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                res = num;
            }
        }
        return res;
    }


}