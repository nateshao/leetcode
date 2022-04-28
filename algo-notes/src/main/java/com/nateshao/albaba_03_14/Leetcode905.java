package com.nateshao.albaba_03_14;

/**
 * @date Created by 邵桐杰 on 2022/4/28 22:21
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Leetcode905 {
    /**
     * 方法三：原地交换
     * 思路
     *
     * 记数组 nums 的长度为 n。先从 nums 左侧开始遍历，
     * 如果遇到的是偶数，就表示这个元素已经排好序了，继续从左往右遍历，直到遇到一个奇数。
     * 然后从 nums 右侧开始遍历，如果遇到的是奇数，就表示这个元素已经排好序了，
     * 继续从右往左遍历，直到遇到一个偶数。交换这个奇数和偶数的位置，并且重复两边的遍历，直到在中间相遇，
     * nums 排序完毕。
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = -1, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;

    }
}
