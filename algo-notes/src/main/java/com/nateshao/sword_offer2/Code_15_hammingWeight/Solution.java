package com.nateshao.sword_offer2.Code_15_hammingWeight;

/**
 * @date Created by 邵桐杰 on 2022/3/7 19:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("hammingWeight(11) = " + hammingWeight(11));
        System.out.println("hammingWeight2(11) = " + hammingWeight2(11));
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;

//        return Integer.bitCount(n);
    }

    public static int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    /**
     *
     作者：jyd
     链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
