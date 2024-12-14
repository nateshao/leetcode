package com.nateshao.sword_offer.topic_35_minNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date Created by 邵桐杰 on 2021/12/11 17:03
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 剑指 Offer 45. 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {10, 2};
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("minNumber(nums) = " + minNumber(nums));// minNumber(nums) = 102
        System.out.println("minNumber(nums2) = " + minNumber(nums2));// minNumber(nums2) = 3033459
        System.out.println("minNumber1(nums2) = " + minNumber1(nums2));
        System.out.println("minNumber3(nums2) = " + minNumber3(nums2));
    }

    public static String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);// 转化为String类型
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();
    }

    /**
     * 快排
     * @param strs
     * @param left
     * @param right
     */
    public static void quickSort(String[] strs, int left, int right) {
        if(left >= right) return;
        int i = left, j = right;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[left];
        strs[left] = tmp;
        quickSort(strs, left, i - 1);
        quickSort(strs, i + 1, right);
    }

    /**
     * 思路：先将整型数组转换成 String 数组，然后将 String 数组排序，最后将排好序
     * 的字符串数组拼接出来。关键就是制定排序规则。或使用比较和快排的思想，将前
     * 面的数和最后的数比较，若小则放到最前面，最后再递归调用。
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int len = nums.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public static String minNumber3(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
