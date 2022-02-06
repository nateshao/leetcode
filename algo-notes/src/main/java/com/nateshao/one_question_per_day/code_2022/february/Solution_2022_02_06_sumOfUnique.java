package com.nateshao.one_question_per_day.code_2022.february;

import java.util.HashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2022/1/1 9:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * <p>
 * 1748. 唯一元素的和
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * <p>
 * 请你返回 nums 中唯一元素的 和 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 * 示例 3 ：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 */
public class Solution_2022_02_06_sumOfUnique {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println("sumOfUnique(nums) = " + sumOfUnique(nums));

    }
    /**
     * 方法一：使用HashMap求解
     * 具体方法
     * 遍历数组，将每个元素存入到map中，存的格式是《数字，出现个数》。
     * <p>
     * 最后在遍历一遍map，将出现个数为1的元素求和即可。
     *
     * @param nums
     * @return
     */
    public static int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count == 1) res += key;
        }
        return res;
    }


    /*public int sumOfUnique1(int[] nums) {
        int[] cnt = new int[110];
        for(int i:nums)cnt[i]++;
        int res = 0;
        for(int i = 1;i<=100;i++){
            if(cnt[i]==1)res += i;
        }
        return res;
    }*/

}
