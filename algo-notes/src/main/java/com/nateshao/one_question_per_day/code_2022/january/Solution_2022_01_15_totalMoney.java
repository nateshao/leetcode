package com.nateshao.one_question_per_day.code_2022.january;

/**
 * @date Created by 邵桐杰 on 2022/1/15 23:35
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 1716. 计算力扣银行的钱
 * <p>
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * <p>
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。
 * 在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * <p>
 * 示例 2：
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * <p>
 * 示例 3：
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 *  
 */
public class Solution_2022_01_15_totalMoney {
    public static void main(String[] args) {
        System.out.println("totalMoney2(10) = " + totalMoney2(10));
    }

    /**
     * （优化）模拟
     *     更进一步，每个完整周的起始日金额相比上周起始日金额多1，同时周内每日金额递增 1，
     *     因此相邻完整周的金额之和也满足「等差」性质，可直接使用「等差数列求和」公式 O(1)
     *     求解完整周部分的金额之和；最后一周（若有）的金额也是同理。
     * @param n
     * @return
     */
    public static int totalMoney2(int n) {
        int a = n / 7, b = n % 7;
        int a1 = (1 + 7) * 7 / 2, an = (a + (a + 6)) * 7 / 2;
        int s1 = (a1 + an) * a / 2;
        a++;
        int s2 = (a + (a + b - 1)) * b / 2;
        return s1 + s2;
    }

    public static int totalMoney(int n) {
        int a = n / 7, b = n % 7;
        int ans = 0, k = 1;
        while (a-- > 0) {
            ans += (k + (k + 6)) * 7 / 2;
            k++;
        }
        while (b-- > 0) ans += k++;
        return ans;
    }


}
