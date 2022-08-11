package com.nateshao.sword_offer3.day28;

import java.util.*;

/**
 * @date Created by 邵桐杰 on 2022/8/1 23:33
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day28_permutation {
    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }

    public void dfs(char[] arr, String s, boolean[] visited, Set<String> list) {
        if (s.length() == arr.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(arr, s + String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }

    }
}
