package com.nateshao.sword_offer3.day22;

import java.util.HashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2022/7/23 11:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class Day22_singleNumber_2 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int a = map.getOrDefault(nums[i], 0);
            map.put(nums[i], a + 1);
        }
        for (Integer a : map.keySet()) {
            if (map.get(a) == 1) return a;
        }
        return -1;
    }
}
