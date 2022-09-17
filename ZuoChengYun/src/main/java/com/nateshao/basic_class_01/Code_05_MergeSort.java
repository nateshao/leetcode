package com.nateshao.basic_class_01;

import java.util.Arrays;
/**
 * @date Created by 邵桐杰 on 2021/9/18 20:03
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 归并排序
 */
public class Code_05_MergeSort {

	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 20;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		mergeSort(arr);
		printArray(arr);

	}
	/**
	 * 如果数组的长度为空，或者是数组的长度为1。直接返回，不需要比较
	 * @param arr
	 */
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	/**
	 * 这个范围上只有一个数，直接返回
	 * @param arr
	 * @param l
	 * @param r
	 */
	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1); // L和R中点的位置 （L + R）/ 2
		mergeSort(arr, l, mid); // 左部分排序  T(n/2)
		mergeSort(arr, mid + 1, r); // 右部分排序 T(n/2)
		merge(arr, l, mid, r); // 左部分和右部分合并 O(n)
		// 总的时间复杂度：T(N) = 2T(n/2) + O(N)
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;// 数组l,左侧第一的最小值。
		int p2 = m + 1;// 右侧第一的最小值。
		while (p1 <= m && p2 <= r) { // p1 or p2 谁小取谁，放在新的数组，重新排序数组
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		/**
		 * p1,p2两个数，必有一个数越界
		 */
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i]; // 最后将数组拷贝到arr[i]
		}
	}

	/**
	 * 比较器
	 * @param arr
	 */
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	/**
	 * 生成任意数组
	 * @param maxSize
	 * @param maxValue
	 * @return
	 */
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	/**
	 * 复制数组
	 * @param arr
	 * @return
	 */
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	/**
	 * 两数组是否相等
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 打印数组
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
