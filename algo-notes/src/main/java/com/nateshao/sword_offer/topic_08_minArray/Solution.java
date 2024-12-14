package com.nateshao.sword_offer.topic_08_minArray;

/**
 * @date Created by 邵桐杰 on 2021/11/18 21:41
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 剑指 Offer 08. 旋转数组的最小数字
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 8, 2};
        int i = minArray(arr);
        System.out.println("i = " + i);
        int min = minInReversingList(arr);
        System.out.println("min = " + min);
        int min2 = minInReversingList2(arr);
        System.out.println("min1 = " + min2);
    }

    /**
     * 官方参考
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (numbers[mid] > numbers[j]) i = mid + 1;
            else if (numbers[mid] < numbers[j]) j = mid;
            else j--;
        }
        return numbers[i];
    }

    /**
     * 思路：利用二分法，找到数组的中间元素 mid。
     * 如果中间元素 > 数组第一个元素，在 mid 右边搜索变化点。
     * 如果中间元素 < 数组第一个元素，我们需要在 mid 左边
     * 搜索变化点。当找到变化点时停止搜索，满足 nums[mid] > nums[mid + 1]
     * （mid+1 是最小值）或 nums[mid - 1] > nums[mid]（ mid 是最小值）即可。
     * <p>
     * 解法一：二分查找（变化点），时间复杂度：O(log n)，空间复杂度：O(1)
     *
     * @param array
     * @return
     */
    public static int minInReversingList(int[] array) {
        if (array == null || array.length == 0) return -1;
        if (array.length == 1 || array[array.length - 1] > array[0]) return array[0];

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) return array[mid + 1];
            if (array[mid - 1] > array[mid]) return array[mid];

            if (array[mid] > array[0]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 解法二：二分查找（最左下标），时间复杂度：O(log n)，空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int minInReversingList2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
