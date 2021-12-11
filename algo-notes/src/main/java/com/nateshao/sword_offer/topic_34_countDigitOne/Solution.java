package com.nateshao.sword_offer.topic_34_countDigitOne;

/**
 * @date Created by 邵桐杰 on 2021/12/11 11:00
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 */
public class Solution {
    public static void main(String[] args) {
        int n = 12;
        System.out.println("countDigitOne1(n) = " + countDigitOne1(n));// countDigitOne1(n) = 5
        System.out.println("countDigitOne2(n) = " + countDigitOne2(n));// countDigitOne2(n) = 5
        System.out.println("countDigitOne3(n) = " + countDigitOne3(n));// countDigitOne3(n) = 5
    }

    /**
     * 方法一：计算高低位
     *
     * @param n
     * @return
     */
    public static int countDigitOne1(int n) {
        int count = 0;
        int i = 1;
        int current = 0, after = 0, before = 0;
        while ((n / i != 0)) {
            before = n / (i * 10);// 高位
            current = (n / i % 10);// 当前位
            after = n - (n / i) * i;// 低位
            // 如果为 0,出现 1 的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0) count = count + before * i;
                // 如果为 1,出现 1 的次数由高位和低位决定,高位*当前位+低位+1
            else if (current == 1) count = count + before * i + after + 1;
                // 如果大于 1,出现 1 的次数由高位决定,（高位数字+1）* 当前位数
            else if (current > 1) count = count + (before + 1) * i;
            // 前移一位
            i = i * 10;
        }
        return count;
    }

    /**
     * 方法二：公式法
     *
     * @param n
     * @return
     */
    public static int countDigitOne2(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

    /**
     * 方法三
     * @param n
     * @return
     */
    public static int countDigitOne3(int n) {
        return f(n);
    }

    //下面我们都用 1234 和 2345 来举例
    private static int f(int n){
        // 上一级递归 n = 20、10之类的整十整百之类的情况；以及n=0的情况
        if(n== 0) return 0;
        // n < 10 即为个位，这样子只有一个1
        if(n < 10) return 1;

        String s = String.valueOf(n);
        //长度：按例子来说是4位
        int length = s.length();

        //这个base是解题速度100%的关键，本例中的是999中1的个数：300
        // 99的话就是20 ; 9的话就是1 ；9999就是4000 这里大家应该发现规律了吧。
        int base = (length-1)*(int)Math.pow(10,length-2);

        //high就是最高位的数字
        int high = s.charAt(0) - '0';
        //cur就是当前所数量级，即1000
        int cur = (int)Math.pow(10,length -1);
        if(high == 1){
            //最高位为1，1+n-cur就是1000~1234中由千位数提供的1的个数，剩下的f函数就是求1000~1234中由234产生的1的个数
            return base + 1 + n - cur + f(n - high * cur);
        }else{
            //这个自己思考
            return base * high + cur + f(n- high * cur);
        }
    }

}
