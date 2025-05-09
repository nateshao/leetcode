package com.nateshao.codetop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/8/11 23:49
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Code1_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        // 记录结果
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * 滑动窗口+hashSet
     * 1. 定义双指针
     * 2. 在s.length遍历，
     * 当set不含有重复元素。右指针向右移动，不重复就添加进去，右指针++
     * 如果含有重复元素，右指针不动，左指针向右移动，删除左指针经过的重复元素，left++;
     * 3. res = 每次记录set的大小
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        //维护当前最长不重复字符子串
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) { //未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            } else {
                //right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());//每一次计算当前set子串的长度
        }
        return res;
    }

    /**
     * 最长不重复字串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        // 存放结果
        Map<Character, Integer> window = new HashMap<>();
        // 定义左右指针
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int lengthOfLongestSubstring4(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring5(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    // hashmap

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring6(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;// 右指针++
            window.put(c, window.getOrDefault(c, 0));
            while (window.get(left) > 1) {
                left++;
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * hashset
     */
    public static int lengthOfLongestSubstring7(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    public static int lengthOfLongestSubstring8(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0));
            while (window.get(left) > 1) {
                left++;
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * hashset
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring9(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(right);
                right++;
            } else {
                set.remove(s.charAt(left));
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    /**
     * hashmap
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring10(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0));
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring7("abcabcbb");
        System.out.println(abcabcbb);
    }
}
