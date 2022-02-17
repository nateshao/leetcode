package com.nateshao.basic_01_ten_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * @date Created by 邵桐杰 on 2021/11/8 17:48
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Code_05_QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr        待排序列
     * @param leftIndex  起始位置
     * @param rightIndex 结束位置
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        /**
         * 如果左边大于右边，则return
         */
        if (leftIndex >= rightIndex) return;

        int left = leftIndex;
        int right = rightIndex;
        // 选第一个元素为基准值
        int key = arr[left];

        /**
         * 从左右两边交替扫描
         */
        while (left < right) {
            // 从右往左
            if (right > left && arr[right] >= key) {
                right--;
            }

            arr[left] = arr[right];
            // 从左往右
            while (left < right && arr[left] <= key) {
                left++;
            }

            arr[right] = arr[left];

        }
        arr[left] = key;
        quickSort(arr, leftIndex, left - 1);
        quickSort(arr, right + 1, rightIndex);

    }


    @Test
    public void  testA(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name",null );
        map.put("name","shao");
        System.out.println(map.get("name"));
    }
}