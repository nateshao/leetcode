package com.nateshao.sword_offer2.code_55_2;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @date Created by 邵桐杰 on 2022/10/2 23:23
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {

    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int[] res = new int[2];
        Iterator<Integer> iterator = set.iterator();
        res[0] = iterator.next();
        res[1] = iterator.next();
        return res;
    }

    public int[] singleNumbers2(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums)               // 1. 遍历异或
            n ^= num;
        while ((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for (int num : nums) {              // 3. 遍历 nums 分组
            if ((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[]{x, y};          // 5. 返回出现一次的数字
    }

}