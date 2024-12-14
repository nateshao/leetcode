package com.nateshao.zijie_code_66;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/3/16 9:31
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/tJau2o/
 * bytedance-006. 夏季特惠
 * 某公司游戏平台的夏季特惠开始了，你决定入手一些游戏。现在你一共有X元的预算，该平台上所有的 n 个游戏均有折扣，标号为 i 的游戏的原价 a_ia
 * i
 * ​
 *   元，现价只要 b_ib
 * i
 * ​
 *  元（也就是说该游戏可以优惠 a_i - b_ia
 * i
 * ​
 *  −b
 * i
 * ​
 *   元）并且你购买该游戏能获得快乐值为 w_iw
 * i
 * ​
 *  。由于优惠的存在，你可能做出一些冲动消费导致最终买游戏的总费用超过预算，但只要满足获得的总优惠金额不低于超过预算的总金额，那在心理上就不会觉得吃亏。现在你希望在心理上不觉得吃亏的前提下，获得尽可能多的快乐值。
 *
 * 格式：
 *
 *
 * 输入：
 * - 第一行包含两个数 n 和 X 。
 * - 接下来 n 行包含每个游戏的信息，原价 ai,现价 bi，能获得的快乐值为 wi 。
 * 输出：
 * - 输出一个数字，表示你能获得的最大快乐值。
 * 示例 1：
 *
 *
 * 输入：
 *      4 100
 *      100 73 60
 *      100 89 35
 *      30 21 30
 *      10 8 10
 * 输出：100
 * 解释：买 1、3、4 三款游戏，获得总优惠 38 元，总金额 102 元超预算 2 元，满足条件，获得 100 快乐值。
 * 示例 2：
 *
 *
 * 输入：
 *      3 100
 *      100 100 60
 *      80 80 35
 *      21 21 30
 * 输出：60
 * 解释：只能买下第一个游戏，获得 60 的快乐值。
 * 示例 3：
 *
 *
 * 输入：
 *      2 100
 *      100 30 35
 *      140 140 100
 * 输出：135
 * 解释：两款游戏都买，第一款游戏获得优惠 70 元，总开销 170 元，超过预算 70 元，超出预算金额不大于获得
 */
public class Day06_main {
    public static void main(String[] args) {
        // 1. 输入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int X = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] w = new int[n];

        // 2. 重新计算重量: 重量 <= 0 的物品设置为0
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            w[i] = sc.nextInt();
            int weight = b[i] - (a[i] - b[i]);
            b[i] = Math.max(0, weight); // 作为物品重量
            X += weight > 0 ? 0 : -weight; // 溢出部分用于拓展背包容量(实际上等价于降低物品重量, 但是物品重量到0已经不能继续减少了，所以溢出部分可以提高背包容量。)
        }

        // 3. 使用01背包
        long[] dp = new long[X + 1]; // 观察测试用例范围这里用long
        for (int i = 0; i < n; i++) {
            for (int j = X; j >= b[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - b[i]] + w[i]);
            }
        }
        System.out.println(dp[X]);
    }
}
