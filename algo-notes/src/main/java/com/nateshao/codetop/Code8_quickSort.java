package com.nateshao.codetop;

import java.util.Arrays;

public class Code8_quickSort {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 主函数：快速排序
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return; // 递归终止条件：子数组长度为 0 或 1

        // 使用三数取中法选择基准，并将基准移动到最左边
        int pivotIndex = medianOfThree(arr, left, right);
        swap(arr, left, pivotIndex);

        // 分区操作，返回基准的最终位置
        int partitionIndex = partition(arr, left, right);

        // 递归处理基准左侧子数组
        quickSort(arr, left, partitionIndex - 1);

        // 递归处理基准右侧子数组
        quickSort(arr, partitionIndex + 1, right);
    }

    // 分区函数：将数组划分为小于基准和大于基准的两部分
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // 基准值设为最左元素
        int l = left + 1; // 左指针从基准右侧开始
        int r = right; // 右指针从末尾开始

        while (l <= r) {
            // 左指针向右移动，直到找到一个大于基准的元素
            while (l <= r && arr[l] <= pivot) l++;
            // 右指针向左移动，直到找到一个小于或等于基准的元素
            while (l <= r && arr[r] > pivot) r--;
            // 如果左指针和右指针未交错，则交换两者的值
            if (l < r) {
                swap(arr, l, r);
            }
        }

        // 将基准值放到最终位置（右指针所在位置）
        swap(arr, left, r);
        return r; // 返回基准的最终位置
    }

    // 三数取中法：选择最左、中间、最右元素的中间值作为基准
    private int medianOfThree(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2; // 计算中间位置
        // 保证最左元素 <= 中间元素
        if (arr[left] > arr[mid]) swap(arr, left, mid);
        // 保证最左元素 <= 最右元素
        if (arr[left] > arr[right]) swap(arr, left, right);
        // 保证中间元素 <= 最右元素
        if (arr[mid] > arr[right]) swap(arr, mid, right);
        return mid; // 返回中间值索引
    }

    // 交换数组中的两个元素
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

/**
 * public void testQuickSort() {
 *         int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
 *         quickSort(arr, 0, arr.length - 1);
 *         System.out.println(Arrays.toString(arr));
 *     }
 *
 *     private void quickSort(int[] arr, int leftIndex, int rightIndex) {
 *         if (leftIndex >= rightIndex) return;
 *
 *         int left = leftIndex, right = rightIndex;
 *         int key = arr[left];
 *         while (left < right) {
 *             while (right > left && arr[right] > key) right--;
 *
 *             arr[left] = arr[right];
 *             while (left < right && arr[left] < key) left++;
 *
 *             arr[right] = arr[left];
 *         }
 *         arr[left] = key;
 *         quickSort(arr, leftIndex, left - 1);
 *         quickSort(arr, right + 1, rightIndex);
 *     }
 */
}
