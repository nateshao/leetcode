package com.nateshao.sword_offer2.Code_46_translateNum;

/**
 * @date Created by 邵桐杰 on 2022/4/18 17:20
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        //获取输入数字的余数，然后递归的计算翻译方法
        int ba = num % 100;
        //如果小于等于9或者大于等于26的时候，余数不能按照2位数字组合，比如56，只能拆分为5和6；反例25，可以拆分为2和5，也可以作为25一个整体进行翻译。
        if (ba <= 9 || ba >= 26) {
            return translateNum(num / 10);
        }
        // ba=[10, 25]时，既可以当做一个字母，也可以当做两个字母
        else {
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }
}
