package com.nateshao.one_question_per_day.code_2022.may;

/**
 * @date Created by 邵桐杰 on 2022/5/1 10:34
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输入:1
 * 示例 3:
 *
 * 输入:s = "bb"
 * 输入: 2
 */
public class Solution_2022_05_01_longestPalindrome {

    /**
     * 在对char数组遍历的时候 只能出现一个个数为奇数的字符 所以我们直接记录有多少个字符出现次数为奇数就可以了啊 不用额外判断了
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        // 找出可以构成最长回文串的长度
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}
