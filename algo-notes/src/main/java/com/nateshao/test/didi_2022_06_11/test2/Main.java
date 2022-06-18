package com.nateshao.test.didi_2022_06_11.test2;

/**
 * @date Created by 邵桐杰 on 2022/6/11 20:11
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 *
 * 滴滴 2023届实习生 后端研发试卷在线考试 - 正式考试阶段
 * 编程题|20分1/2
 * 序列拆分
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给出一个由正整数组成的序列。请判断能否将其中的每个数染成红色或蓝色，使得染成红色的数按顺序构成一个单调递增的序列，且染成蓝色的数按顺序构成一个单调递减的序列。
 *
 *
 *
 * 输入描述
 * 第一行有一个正整数T(1<=T<=10)，代表测试数据的组数。
 *
 * 每组测试数据的第一行有一个正整数n(1<=n<=500)，代表序列的长度。
 *
 * 第二行有n个互不相同的范围在1到n之间的正整数，代表该序列。
 *
 * 输出描述
 * 若可以按给出的规则染色，则输出Yes，否则输出No。
 *
 *
 * 样例输入
 * 3
 * 6
 * 3 6 5 1 4 2
 * 7
 * 7 4 1 3 2 5 6
 * 6
 * 1 4 3 6 5 2
 * 样例输出
 * No
 * Yes
 * No
 *
 * 提示
 * 如样例1中第二组，将1,2,5,6染成红色，7,4,3染成蓝色即是一个合法的染色方案。
 *
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */
public class Main {
    public static void main(String[] args) {
        String arr = "abababa";
        String t1 = "aba", t2 = "cc";
        System.out.println(replaceSpace(arr));

    }
    public static String replaceSpace(String s) {
        return s.replace("aba","cc");
    }

    public String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c==' ')res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
