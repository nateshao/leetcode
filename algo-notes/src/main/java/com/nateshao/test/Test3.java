package com.nateshao.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/6/15 12:21
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Test3 {
    public static void main(String[] args) {

    }

    public String demo(String str) {
        String s = str.toUpperCase();
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                list.add(0);
            } else {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    list.add(i);
                }
            }
        }
        for (Integer n : list) {
            sb.append(str.charAt(n));
        }
        return sb.toString();

    }


    //每个字符串由字母和数字组成，将字母和数字存入一个数组
    public void charAll(ArrayList a) {
        for (char i = 'a'; i <= 'z'; i++) {
            a.add(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            a.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            a.add(i);
        }

    }

    //set是不可重复的
    //Count字符串数目,Str_length字符串长度
    public List<String> rd(int Count, int Str_length) {
        List<String> list = new ArrayList<String>();
        //字母和数字组成
        ArrayList a = new ArrayList();
        charAll(a);
        //set
        HashSet s1 = new HashSet();
        HashSet s2 = new HashSet();
        //随机获得元素
        while (true) {
            //在a.size()中获取随机数
            int a1 = (int) (Math.random() * a.size());
            //获取到的数，存到数组中
            s1.add(a.get(a1));
            //Str_length字符串长度够了就生成字符串，存到s2数组里面
            if (s1.size() == Str_length) {
                //生成字符串
                StringBuilder sb = new StringBuilder();
                for (Object o : s1) {
                    sb.append(o.toString());
                }
                //字符串存到s2数组里面
                s2.add(sb);
                break;
            }
            if (s2.size() == Count) {
                break;
            }
        }
        for (Object str : s2) {
            list.add(str.toString());
        }
        return list;
    }

}