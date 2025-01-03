package com.nateshao.sword_offer2.Code_50_firstUniqChar;

import java.util.HashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2022/4/19 20:43
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * <p>
 * 输入：s = ""
 * 输出：' '
 */
public class Solution {
    /**
     * hashmap
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        char[] chars = s.toCharArray();
        Map<Character, Boolean> hashMap = new HashMap<>();
        for (char c : chars) {
            hashMap.put(c, !hashMap.containsKey(c));
        }
        for (char c : chars) {
            if (hashMap.get(c)) return c;
        }
        return ' ';
    }

    /**
     * 字典查找
     * 先建立一个长度为26的数组，对应26个英文字母。然后遍历字符串s，
     * s[i]-'a'对应的就是在res在数组中的下标，a-a就是res[0]，z-a就是对应res[25]，以此类推。
     * <p>
     * 遍历完一次之后，res数组中已经存放各个字母出现的次数了，没出现的就是默认值0
     * 然后再遍历一次，找到res[s[i]-'a']==1的，因为是要找到字符串中第一次出现一次的字符，所以还是从头遍历字符串s，
     * 然后在res数组中第一个找值为1，直接返回即可。
     *
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        if (s.equals("")) return ' ';
        //创建‘a'-'z'的字典
        int[] target = new int[26];
        //第一次遍历，将字符统计到字典数组
        for (int i = 0; i < s.length(); i++) target[s.charAt(i) - 'a']++;
        //第二次遍历，从字典数组获取次数
        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }

    public char firstUniqChar3(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();// 转为字符数组
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';
    }

}
