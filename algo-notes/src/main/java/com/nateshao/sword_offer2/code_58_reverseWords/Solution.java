package com.nateshao.sword_offer2.code_58_reverseWords;

/**
 * @date Created by 邵桐杰 on 2022/10/3 11:41
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: 剑指 Offer 58 - I. 翻转单词顺序
 * 单词反转，反转单词
 */
public class Solution {
    /**
     * 先去掉首尾空格，遇到空格分隔单词
     * 倒序遍历输出，如果遇到空格就继续
     * 不是空格就相加
     * res.append()添加进去
     * 最后res.toString()输出。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if (strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    /**
     * 将传进来的字符串用空格拆分
     * 从尾巴开始遍历
     * 如果等于空格就继续
     * 如果i==0遍历完了，就去掉空格，后面先去掉空格再加上去
     * 最后toString 输出
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        //将传进来的字符串以空格拆分
        String[] strings = s.trim().split(" ");
        StringBuffer res = new StringBuffer();
        //从尾巴开始遍历
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) continue;

            //到头了，append然后去空格
            if (i == 0) res.append(strings[i].trim());
            else
                // 怕有多余的空格，去掉，再加上去
                res.append(strings[i].trim()).append(" ");
        }
        //输出String 完事，安排！
        return res.toString();
    }

}
