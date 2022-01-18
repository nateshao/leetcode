package com.nateshao.sword_offer.topic_40_singleNumbers_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2022/1/18 21:33
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {9, 1, 7, 9, 7, 9, 7};
        int[] arr2 = {3,4,3,3};
        System.out.println("singleNumber(arr) = " + singleNumber(arr));
        System.out.println("singleNumber(arr2) = " + singleNumber(arr2));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //先把数字存储到map中，其中key存储的是当前数字，value是
        //数字的出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //最后在遍历map中的所有元素，返回value值等于1的
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }


}
