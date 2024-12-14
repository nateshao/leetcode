package com.nateshao.one_question_per_day.code_2021;

/**
 * @date Created by 邵桐杰 on 2021/12/31 16:44
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 507. 完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * 示例 1：
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 * <p>
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：num = 8128
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        System.out.println("checkPerfectNumber(28) = " + checkPerfectNumber(28));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int ans = 1;
        for (int i = 2; i < num / i; i++) {
            if (num % i == 0) {
                ans += i;
                if (i * i != num) {
                    ans += num / i;
                }
            }
        }
        return ans == num;
    }
}