package com.nateshao.zijie_code_66;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/3/16 18:47
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Day09_bytedance_010 {
    public static void main(String[] args) {
        // 1. 输入数据
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] sNums = in.substring(1, in.length() - 1).split(",");
        Integer[] nums = new Integer[sNums.length];
        for (int i = 0; i < sNums.length; i++) nums[i] = Integer.parseInt(sNums[i]);

        // 2. 不能简单按照字典序排序, 因为字典序中 10 > 1, 但是实际中应该 1 放在10前面, 因此直接按照两个组合大小返回 101和 110对比。
        Arrays.sort(nums, (a, b) -> {
            return Integer.compare(Integer.parseInt("" + b + a), Integer.parseInt("" + a + b));
        });

        // 3. 按序组成结果
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            result.append("" + nums[i]);
        }
        System.out.println(result.toString());
    }
}
