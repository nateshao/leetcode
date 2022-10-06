package com.nateshao.test_10_03;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/10/3 23:41
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public ArrayList<ArrayList<Integer>> threeSum (int[] nums) {
        // write code here
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]>0)break;
            if (i>0&&nums[i]==nums[i-1])continue;
            int left = i+1,right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum<0){
                    while (left<right&&nums[left]==nums[++left]);
                }else if (sum>0){
                    while (left<right&&nums[right]==nums[--right]);
                }else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
                    while (left<right&&nums[left]==nums[++left]);
                    while (left<right&&nums[right]==nums[--right]);
                }
            }
        }
        return res;
    }
}
