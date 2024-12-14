package com.nateshao.one_question_per_day.code_2022.july;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/7/7 16:12
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Code_07_07_FindGoogle {
    public static void main(String[] args) {
        String s = "#include"+"using namespace std;"+"//Google test"+"int main(){"+"return 0;"+"}";
        List<String> list = new ArrayList<>();
        list.add(s);
        System.out.println("findGoogle(s) = " + findGoogle((ArrayList<String>) list));
    }
    /**
     * 给您一个字符串形式的C ++文件（每行是一个字符串），我们希望您在注释行中找到“ Google”。
     * 如果注释行中有“ Google”，则返回true，否则返回false。
     * C++有两种注释方式，一种是单行注释 //，代表着//后面的本行内容均为注释，
     * 另一种是多行注释，/* 和 这两者之间的部分均为注释。
     *
     * @param s
     * @return
     */
    public static boolean findGoogle(ArrayList<String> s) {
        if (s == null || s.size() == 0) return false;
        // 多行注释
        String start = "/*";
        String end = "*/";
        for (int i = 0; i < s.size(); i++) {
            String str = s.get(i); // 获取元素
            str = str.trim();// 去空格
            if (str.indexOf("//") != -1) { // 单行注释
                if (str.indexOf("Google") != -1) return true;
            }
            if (str.indexOf(start) != -1) { /* 多行注释 */
                if (str.indexOf("Google") != -1) return true;
                while (str.indexOf(end) != -1) {
                    if (str.indexOf("Google") != -1) return true;
                    i++;
                    if (i >= s.size()) return false;
                    str = s.get(i);
                }
            }
        }
        return false;//跑完了还是没发现注释内Google
    }
}




