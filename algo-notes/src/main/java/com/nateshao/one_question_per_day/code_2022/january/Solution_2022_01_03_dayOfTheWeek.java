package com.nateshao.one_question_per_day.code_2022.january;


/**
 * @date Created by 邵桐杰 on 2022/1/1 11:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 1185. 一周中的第几天
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_2022_01_03_dayOfTheWeek {
    public static void main(String[] args) {
        int day = 31;
        int month = 8;
        int year = 2019;
        System.out.println("dayOfTheWeek(day, month, year) = " + dayOfTheWeek(day, month, year));
    }

    /**
     * 题目保证日期是在 1971 到 2100 之间，我们可以计算给定日期距离 1970 的最后一天（星期四）间隔了多少天，从而得知给定日期是周几。
     * <p>
     * 具体的，可以先通过循环处理计算年份在 [1971, year - 1][1971,year−1] 时间段，经过了多少天（注意平年为 365365，闰年为 366366）；
     * 然后再处理当前年 yearyear 的月份在 [1, month - 1][1,month−1] 时间段 ，经过了多少天（注意当天年是否为闰年，特殊处理 22 月份），
     * 最后计算当前月 monthmonth 经过了多少天，即再增加 dayday 天。
     * 得到距离 1970 的最后一天（星期四）的天数后进行取模，即可映射回答案。
     */
    static String[] ss = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static String dayOfTheWeek(int day, int month, int year) {
        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            ans += nums[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) ans++;
        }
        ans += day;
        return ss[ans % 7];

    }
}
