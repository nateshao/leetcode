package com.nateshao.test_09_21;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/9/21 17:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
 *  1,2,2,3,4,5,6,7,8,9   target  = 7
 *  [2,2,3],[3,4],[7]
 */
public class MainTest {
    public static void main(String[] args) {
        int target = 7;
        int[] arr = {1, 2, 2, 3, 4, 5, 6, 7, 8};
        int[] sum = getSum(arr, target);
        for (int i : sum) {
            System.out.print(" " + i);
        }
    }

    /**
     * 思路：滑动窗口
     *
     * @param arr
     * @return
     */
    public static int[] getSum(int[] arr, int target) {
        Arrays.sort(arr);
//        ArrayList<Integer> res = new ArrayList<>();
        int res = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            // 可变的滑动窗口
            if (sum > target) {
                res = Math.max(res, arr[left]);
//                Math.max()
                left++;
            } else if (sum < target) {
                res = Math.min(arr[right], arr[left]);
                right--;
            } else return new int[]{arr[left], arr[right], res};
        }
        return null;
    }


    @Test
    public void test() {
        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        findSum(num, sum);
    }

    public void findSum(int[] num, int sum) {
        for (int i = 0; i < num.length; i++) {
            int res = 0;
            int left = i;
            int right = i;
            while (res < sum) {
                res += num[right++];
            }
            // 输出结果
            if (res == sum) {
                for (int j = left; j < right; j++) {
                    System.out.print(num[j] + " ");
                }
                System.out.println();
            }
        }
    }
}