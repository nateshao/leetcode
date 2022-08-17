package com.nateshao.test.test_07_26;

import java.util.HashMap;

/**
 * @date Created by 邵桐杰 on 2022/7/26 19:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 给定字符串，给出重复次数最多的一个。获取最多的次数？
 *
 *
 */
public class MaxString {
    public static void main(String[] args) {
        String[] strs = {"a","b","b","c"};
        System.out.println("getMaxString(strs) = " + getMaxString(strs));
    }
    /**
     * 思路一：暴力：循环遍历字符串，记录下标相同的，返回结果
     * 思路二：hashmap, 遍历字符串，相同的累加，返回结果集。
     * 最多次数+结果：
     * @return
     */
    public static int getMaxString(String[] strs){
        // "a,b,c"
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])){
                res++;
                map.put(strs[i],res);
            }
           res = Math.max(map.getOrDefault(strs[i],res),res);
        }
        return res;
    }

}
