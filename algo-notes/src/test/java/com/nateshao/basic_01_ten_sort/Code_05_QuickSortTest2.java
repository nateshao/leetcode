package com.nateshao.basic_01_ten_sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/10/21 13:40
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Code_05_QuickSortTest2 {
    @Test
    public void testQuickSort() {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex>=rightIndex)return;;
        int left = leftIndex,right = rightIndex;
        int key = arr[left];
        while (left<right){
            while (right>left&&arr[right]>key){
                right--;
            }
           arr[left] = arr[right];


            while (left<right&&arr[left]<key){
                left++;
            }
          arr[right]  = arr[left];
        }
       arr[left] = key;
        quickSort(arr,leftIndex,left-1);
        quickSort(arr,right+1,rightIndex);

    }

}
