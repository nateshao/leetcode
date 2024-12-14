package com.nateshao.guangnayuan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/3/8 11:50
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 广纳院
 * <p>
 * 1. 一段长的文本被两种不同切割方法切割成多段文本，两种切割方法产生的相邻片段具有重叠部分，请设计一个算法对这些片段进行拼接，以输出完整的文本。
 * <p>
 * 例如, 有下列切割后的片段：
 * <p>
 * abcdef， ghij， klmn， abc，defgh， ijklmn
 * <p>
 * 进行拼接后，输出原文本：
 * <p>
 * abcdefghijklmn
 */
public class Solution {

    public static void main(String[] args) {
        String[] s = {"abcdef", "ghij", "klmn", "abc", "defgh", "ijklmn"};
        

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int index = list.indexOf(s.charAt(i));
            if (index == -1) {
                list.add(s.charAt(i));
                maxLength = Math.max(list.size(), maxLength);
            } else {
                for (int j = index; j >= 0; j--) {
                    list.remove(j);
                }
                list.add(s.charAt(i));
            }
        }
        return maxLength;
    }
}
