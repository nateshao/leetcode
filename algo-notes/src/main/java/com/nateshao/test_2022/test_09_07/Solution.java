package com.nateshao.test_2022.test_09_07;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/9/7 17:40
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 翻牌
     *
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    public String showDown(String inHand) {
        // write code here
        String res = "GaoPai";
        List<List<Character>> lists = toList(inHand);
        if (isYiDui(lists)) {
            res = "YiDui";
        }
        int count = 2;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() >= 2) {
                --count;
            }
            if (count == 0) {
                res = "LiangDui";
                break;
            }
        }
        if (isSanTiao(lists)) {
            res = "SanTiao";
        }
        if (isShunZi(lists) != 0) {
            res = "ShunZi";

        }
        if (isTongHua(lists)) {
            res = "TongHua";
        }
        if (isYiDui(lists) && isSanTiao(lists)) {
            res = "HuLu";
        }
        for (List<Character> list : lists) {
            if (list.size() >= 4) {
                res = "SiTiao";
                break;
            }
        }
        if (isShunZi(lists) == 1 && isTongHua(lists)) {
            res = "TongHuaShun";
        }
        if (isShunZi(lists) == 2 && isTongHua(lists)) {
            res = "HuaJiaTongHuaShun";
        }
        return res;

    }

    private boolean isTongHua(List<List<Character>> lists) {
        int[] ints = new int[4];
        for (List<Character> list : lists) {
            for (Character character : list) {
                if (character.equals('S')) {
                    ++ints[0];
                } else if (character.equals('H')) {
                    ++ints[1];
                } else if (character.equals('C')) {
                    ++ints[2];
                } else {
                    ++ints[3];
                }
            }
        }
        for (int i : ints) {
            if (i >= 5) return true;
        }
        return false;
    }

    private int isShunZi(List<List<Character>> lists) {
        int res = 0;
        for (int i = 0; i <= 8; i++) {
            if (lists.get(i).size() >= 1 && lists.get(i + 1).size() >= 1) {
                res = 1;
                break;
            }
        }

        if (lists.get(9).size() >= 1 && lists.get(10).size() >= 1 && lists.get(11).size() >= 1)
            res = 2;
        return res;
    }

    private boolean isYiDui(List<List<Character>> lists) {
        boolean res = false;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() == 2) {
                res = true;
                break;
            }
        }
        return res;
    }

    private boolean isSanTiao(List<List<Character>> lists) {
        boolean res = false;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() == 3) {
                res = true;
                break;
            }
        }
        return res;
    }


    private List<List<Character>> toList(String s) {
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 1; i < s.length(); i++) {
            int index = 0;
            char c = s.charAt(i);
            if (c == 'A') {
            } else if (c == 'K') {
                index = 12;
            } else if (c == 'Q') {
                index = 11;
            } else if (c == 'J') {
                index = 10;
            } else if (c == '1') {
                index = 9;
            } else {
                index = c - '0' - 1;
            }
            lists.get(index).add(s.charAt(i - 1));
            if (index == 9) ++i;
        }
        return lists;
    }


}
