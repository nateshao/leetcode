package com.nateshao.sword_offer2.Code_21_exchange;

/**
 * @date Created by 邵桐杰 on 2022/3/8 8:45
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] res = exchange(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public static int[] exchange(int[] nums) {
        // if (nums == null || nums.length == 0) return null;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
