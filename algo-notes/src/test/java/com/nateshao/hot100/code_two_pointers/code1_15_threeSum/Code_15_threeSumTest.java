package com.nateshao.hot100.code_two_pointers.code1_15_threeSum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @date Created by 邵桐杰 on 2022/9/16 9:31
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Code_15_threeSumTest {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSumTwoPoiters(nums);
        res.stream().forEach(list-> System.out.println("list = " + list));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break; // 后端大于0，排除
            if (k > 0 && nums[k] == nums[k - 1]) continue; // 重复的情况
            // 定义左右指针
            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ;// 左指针前进并去重
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) ;// 右指针前进并去重
                } else {
                    res.add(Arrays.asList(nums[k], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) ;// 左指针前进并去重
                    while (left < right && nums[right] == nums[--right]) ;// 右指针前进并去重
                }
            }
        }
        return res;
    }

    /**
     * 双指针
     * 遍历数组
     * 先排序，定义左右指针。左右指针由两边向中间走
     * 定义target = nums[i]+nums[j]+nums[k]
     * 如果比target小，left++并去重
     * 如果比target大，right--并去重
     * 如果等于，保存res.add。并去重。
     * return res
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumTwoPoiters(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;// 后面都大于0的，排除
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 重复
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int target = nums[left] + nums[right] + nums[i];
                if (target > 0) {
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (target < 0) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[--right]) ;
                    while (left < right && nums[left] == nums[++left]) ;
                }
            }
        }
        return res;
    }

}