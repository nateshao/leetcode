package com.nateshao.sword_offer.topic_30_permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/2 15:31
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 38. 字符串的排列
 */
public class Solution {

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> list = permutation2(str);
        list.stream().forEach(lists-> System.out.print( lists+" " )); // abc acb bac bca cab cba
        System.out.println();
        for (String s : list) {
            System.out.print(s + " "); // abc acb bac bca cab cba
        }
    }

    /**
     * 剑指offer
     * 解题思路：将当前位置的字符和前一个字符位置交换，递归.
     * @param str
     * @return
     */
    public static ArrayList<String> permutation2(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null) return res;
        helper(res, 0, str.toCharArray());
        // 符合结果的输出顺序
        Collections.sort(res);
        return res;

    }

    private static void helper(ArrayList<String> res, int index, char[] s) {
        if (index == s.length - 1) {
            res.add(String.valueOf(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (i == index || s[index] != s[i]) {
                swap(s, index, i);
                helper(res, index + 1, s);
                swap(s, index, i);
            }
        }
    }

    public static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
    /********************** 精选解答 **************************/
    /**
     * 通过交换来固定某个位置的元素这个思路，
     * 就 abc 这个字符串来说，第一个位置可以放 a 或者 b 或者 c，但是如果确定要放某个字符，
     * 比如第一个位置放 a，那么第二个位置就只能放 b 或者 c；
     * 如果第一个位置放 b，那么第二个位置就只能放 a 或者 c；
     * 如果第一个位置放 c，那么第二个位置就只能放 a 或者 b；
     * 当把某个字符移动到第一位以后，暂时第一位的字符就固定住了，
     * 这时再去确定第二个位置的元素，并且此时第一个位置的元素不会再出现在后面的位置上，
     * 依次类推直到确定所有位置的元素，再往前回溯确定每个位置上其他可能出现的元素。
     */
    //为了让递归函数添加结果方便，定义到函数之外，这样无需带到递归函数的参数列表中
    List<String> list = new ArrayList<>();
    //同；但是其赋值依赖c，定义声明分开
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        //从第一层开始递归
        dfs(0);
        //将字符串数组ArrayList转化为String类型数组
        return list.toArray(new String[list.size()]);
    }

    public void dfs(int x) {
        //当递归函数到达第三层，就返回，因为此时第二第三个位置已经发生了交换
        if (x == c.length - 1) {
            //将字符数组转换为字符串
            list.add(String.valueOf(c));
            return;
        }
        //为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();
        //这里就很巧妙了,第一层可以是a,b,c那么就有三种情况，这里i = x,正巧dfs(0)，正好i = 0开始
        // 当第二层只有两种情况，dfs(1）i = 1开始
        for (int i = x; i < c.length; i++){
            //发生剪枝，当包含这个元素的时候，直接跳过
            if (set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            //交换元素，这里很是巧妙，当在第二层dfs(1),x = 1,那么i = 1或者 2， 不是交换1和1，要就是交换1和2
            swap(i,x);
            //进入下一层递归
            dfs(x + 1);
            //返回时交换回来，这样保证到达第1层的时候，一直都是abc。这里捋顺一下，开始一直都是abc，那么第一位置总共就3个交换
            //分别是a与a交换，这个就相当于 x = 0, i = 0;
            //     a与b交换            x = 0, i = 1;
            //     a与c交换            x = 0, i = 2;
            //就相当于上图中开始的三条路径
            //第一个元素固定后，每个引出两条路径,
            //     b与b交换            x = 1, i = 1;
            //     b与c交换            x = 1, i = 2;
            //所以，结合上图，在每条路径上标注上i的值，就会非常容易好理解了
            swap(i,x);
        }
    }
    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }

}
