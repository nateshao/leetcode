package com.nateshao.one_question_per_day.code_2022.january;

import java.util.*;

/**
 * @date Created by 邵桐杰 on 2022/1/30 10:32
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 * 884. 两句话中的不常见单词
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * <p>
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * <p>
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 *
 * 示例 1：
 * <p>
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * <p>
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 */
public class Solution_2022_01_30_uncommonFromSentences {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：令 n 和 m 分别为两字符串长度，复杂度为 O(n + m)
     * 空间复杂度：O(n + m)
     * @param A
     * @param B
     * @return
     */
    public static String[] uncommonFromSentences(String A, String B) {
        // 1. 合并A,B放到一个字符串数组中
        String[] AB = (A + " " + B).split(" ");
        // 2. 计算每一个字符出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < AB.length; i++) {
            map.put(AB[i], map.getOrDefault(AB[i], 0) + 1);// 有值就取AB[i]，没有就取0
        }
        // 3. 如果出现的次数为1，就是唯一的不常见单词
        ArrayList<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }

    /**
     * 根据题意进行模拟即可，先使用「哈希表」对两字符串进行「词频统计」，然后分别从两边的「哈希表」出发，统计符合题意的字符串数量。
     *
     * 或是利用某个单词在一边出现一次，另外一边不曾出现，等价于「某个单词总共只出现一次」。
     * @param s1
     * @param s2
     * @return
     */
    public String[] uncommonFromSentences1(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String str = s1 + " " + s2;
        String[] ss = str.split(" ");
        for (String s : ss) map.put(s, map.getOrDefault(s, 0) + 1);
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) if (map.get(s) == 1) list.add(s);
        return list.toArray(new String[list.size()]);
    }
}
