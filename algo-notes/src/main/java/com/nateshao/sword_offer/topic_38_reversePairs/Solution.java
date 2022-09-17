package com.nateshao.sword_offer.topic_38_reversePairs;

/**
 * @date Created by 邵桐杰 on 2021/12/14 20:45
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 思路：本质是归并排序，在比较时加入全局变量 count 进行记录逆序对的个数，若
 * data[start] >= data[index] ，则 count 值为 mid+1-start
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        System.out.println("reversePairs(arr) = " + reversePairs(arr));//reversePairs(arr) = 5
        System.out.println("reversePairs1(arr) = " + reversePairs1(arr));
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @return
     * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/
     */
    public static int reversePairs1(int[] nums) {
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /************** k神 **************/
        int[] nums, tmp;
        public int reversePairs2(int[] nums) {
            this.nums = nums;
            tmp = new int[nums.length];
            return mergeSort(0, nums.length - 1);
        }
        private int mergeSort(int l, int r) {
            // 终止条件
            if (l >= r) return 0;
            // 递归划分
            int m = (l + r) / 2;
            int res = mergeSort(l, m) + mergeSort(m + 1, r);
            // 合并阶段
            int i = l, j = m + 1;
            for (int k = l; k <= r; k++)
                tmp[k] = nums[k];
            for (int k = l; k <= r; k++) {
                if (i == m + 1)
                    nums[k] = tmp[j++];
                else if (j == r + 1 || tmp[i] <= tmp[j])
                    nums[k] = tmp[i++];
                else {
                    nums[k] = tmp[j++];
                    res += m - i + 1; // 统计逆序对
                }
            }
            return res;
        }



    /************* 剑指offer *****************/
    private static int count = 0;

    public static int reversePairs(int[] array) {
        if (array == null) return 0;
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private static void mergeSort(int[] data, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    private static void merge(int[] data, int start, int mid, int end) {
        int arr[] = new int[end - start + 1];
        int c = 0;
        int s = start;
        int index = mid + 1;
        while (start <= mid && index <= end) {
            if (data[start] < data[index]) {
                arr[c++] = data[start++];
            } else {
                arr[c++] = data[index++];
                count += mid + 1 - start;
                count %= 1000000007;
            }
        }
        //把左边剩余的数移入数组
        while (start <= mid) {
            arr[c++] = data[start++];
        }
        //把右边剩余的数移入数组
        while (index <= end) {
            arr[c++] = data[index++];
        }
        //把新数组中的数覆盖nums数组
        for (int d : arr) {
            data[s++] = d;
        }
    }
}
