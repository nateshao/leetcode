package com.nateshao.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date Created by 邵桐杰 on 2022/9/26 15:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        String s = "ssabc";
        int repeat = getRepeat(s);
        System.out.println("repeat = " + repeat);
    }

    /**
     * 标签：滑动窗口
     * 暴力解法时间复杂度较高，会达到 O(n^2)故而采取滑动窗口的方法降低时间复杂度
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public static int getRepeat(String s) {
        int n = s.length(), res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < n; right++) {
            char temp = s.charAt(right);
            if (map.containsKey(temp)) {
                left = Math.max(map.get(temp), left);
            }
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;// 记录结果集
        for (right = 0; right < s.length(); right++) {
            char temp = s.charAt(right); //
            if (map.containsKey(temp)) {
                left = Math.max(map.get(temp), left);
            }
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right + 1);
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
     * @date Created by 邵桐杰 on 2023/2/7 20:07
     * @微信公众号 千羽的编程时光
     * @个人网站 www.nateshao.cn
     * @博客 https://nateshao.gitlab.io
     * @GitHub https://github.com/nateshao
     * @Gitee https://gitee.com/nateshao
     * Description:
     */
    public static class Main4 {
        /**
         * 创建三个线程
         * 无线循环
         * a线程无限输出a
         * b线程无限输出b
         * c线程无线输出c
         * <p>
         * 依此输出abc，abc，
         * https://blog.csdn.net/zuishengmengsi_/article/details/55504680
         * @param args
         */
        public static int cnt = 0;
        public static final int COUNT = 30;

        public static void main(String[] args) {

            final Lock lock = new ReentrantLock();
            Thread A = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        lock.lock();
                        if (cnt >= COUNT) {
                            lock.unlock();
                            return;
                        }
                        if (cnt % 3 == 0) {
                            System.out.println("A");
                            cnt++;
                        }
                        lock.unlock();
                    }
                }

            });

            Thread B = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        lock.lock();
                        if (cnt >= COUNT) {
                            lock.unlock();
                            return;
                        }
                        if (cnt % 3 == 1) {
                            System.out.println("B");
                            cnt++;
                        }
                        lock.unlock();
                    }
                }
            });

            Thread C = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        lock.lock();
                        if (cnt >= COUNT) {
                            lock.unlock();
                            return;
                        }
                        if (cnt % 3 == 2) {
                            System.out.println("C");
                            cnt++;
                        }
                        lock.unlock();
                    }
                }
            });
            A.start();
            B.start();
            C.start();
        }
    }
}
