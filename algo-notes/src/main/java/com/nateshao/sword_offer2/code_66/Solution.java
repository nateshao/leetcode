package com.nateshao.sword_offer2.code_66;

/**
 * @date Created by 邵桐杰 on 2022/8/20 19:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class Solution {
    /**
     * 定义结果集：
     * <p>
     * 1. 从左往右累乘
     * 2. 从右往左累乘
     * 3. 返回结果集
     *
     * @param nums
     * @return
     */
    public int[] constructArr(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, cur = 1; i < nums.length; i++) { // 从左往右累乘
            res[i] = cur;
            cur *= nums[i];
        }
        for (int i = nums.length - 1, cur = 1; i >= 0; i--) { // 从右往左累乘
            res[i] *= cur;
            cur *= nums[i];
        }
        return res;
    }

    public int[] constructArr2(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
