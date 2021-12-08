package com.nateshao.sword_offer.topic_32_getLeastNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @date Created by 邵桐杰 on 2021/12/5 19:48
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 40. 最小的k个数
 * 题目描述：输入 n 个整数，找出其中最小的 K 个数。
 * 思路：先将前 K 个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
 */
public class Solution {
    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution(input, k);
        list.stream().forEach(lists -> System.out.print(lists + " "));
        System.out.println("======================");
        int[] numbers = getLeastNumbers(input, k);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    /***
     * 方法一：快排
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        // 子数组长度为 1 时终止递归
        if (leftIndex >= rightIndex) return;
        // 哨兵划分操作（以 arr[left] 作为基准数）
        int left = leftIndex, right = rightIndex;
        while (left < right) {
            while (left < right && arr[right] >= arr[leftIndex]) right--;
            while (left < right && arr[left] <= arr[leftIndex]) left++;
            swap(arr, left, right);
        }
        swap(arr, left, leftIndex);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, leftIndex, left - 1);
        quickSort(arr, left + 1, rightIndex);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**************************  堆  ********************************/
    /**
     * 方法二：
     * 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * 1. 若目前堆的大小小于K，将当前数字放入堆中。
     * 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     *    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[queue.size()];
        int idx = 0;
        for(int num: queue) {
            res[idx++] = num;
        }
        return res;
    }
    /******************** 计数排序 ***********************/
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];

        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) break;
        }
        return res;
    }

    /**************************  剑指offer  *********************/
    /**
     * 大根堆(前 K 小) / 小根堆（前 K 大)
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        int[] kArray = Arrays.copyOfRange(input, 0, k);
        // 创建大根堆
        buildHeap(kArray);
        for (int i = k; i < input.length; i++) {
            if (input[i] < kArray[0]) {
                kArray[0] = input[i];
                maxHeap(kArray, 0);
            }
        }
        for (int i = kArray.length - 1; i >= 0; i--) {
            list.add(kArray[i]);
        }
        return list;
    }

    public static void buildHeap(int[] input) {
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            maxHeap(input, i);
        }
    }

    private static void maxHeap(int[] array, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        int largest = 0;
        if (left < array.length && array[left] > array[i]) largest = left;
        else largest = i;

        if (right < array.length && array[right] > array[largest]) largest = right;

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }
}
