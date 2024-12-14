package com;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;

/**
 * @date Created by 邵桐杰 on 2022/11/20 11:51
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Demo_Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[Integer.MAX_VALUE];
        for (int i = 0; i < res.length; i++) {
            if (set.contains(res[i]))return;
            else set.add(res[i]);
        }
        return;
    }
}
