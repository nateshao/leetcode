package com.nateshao.codetop;

import java.util.Arrays;

public class Code8_quickSort {
    public static void main(String[] args) {
        int[] arr = {110, 12, 4, 5, 6, 7, 8, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, leftIndex, left - 1);
        quickSort(arr, right + 1, rightIndex);
    }

}
