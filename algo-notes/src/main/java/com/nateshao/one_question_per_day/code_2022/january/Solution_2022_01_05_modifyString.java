package com.nateshao.one_question_per_day.code_2022.january;

/**
 * @date Created by 邵桐杰 on 2022/1/5 9:13
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 1576. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 * 示例 2：
 * <p>
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 * 示例 3：
 * <p>
 * 输入：s = "j?qg??b"
 * 输出："jaqgacb"
 * 示例 4：
 * <p>
 * 输入：s = "??yw?ipkj?"
 * 输出："acywaipkja"
 */
public class Solution_2022_01_05_modifyString {
    public static void main(String[] args) {
        String s = "?zs";
        String s2 = "ubv?w";
        String s3 = "j?qg??b";
        String s4 = "??yw?ipkj?";
        System.out.println("modifyString(s) = " + modifyString(s));
        System.out.println("modifyString(s2) = " + modifyString(s2));
        System.out.println("modifyString(s3) = " + modifyString(s3));
        System.out.println("modifyString(s4) = " + modifyString(s4));
    }

    /**
     * 根据题意进行模拟，尝试对每个 s[i]进行替换，能够替换的前提是 s[i]为 ?，
     * 且替换字符与前后字符（若存在）不同，由于只需要确保与前后字符不同，因此必然最多在 3 个字符内找到可替换的值。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/solution/gong-shui-san-xie-jian-dan-zi-fu-chuan-m-fa1u/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static String modifyString(String s) {
//        char[] cs = s.toCharArray();
//        int n = cs.length;
//        for (int i = 0; i < n; i++) {
//            for (int c = 0; c < 3 && cs[i] == '?'; c++) {
//                boolean ok = true;
//                if (i - 1 >= 0 && cs[i - 1] == c + 'a') ok = false;
//                if (i + 1 < 0 && cs[i + 1] == c + 'a') ok = false;
//                if (ok) cs[i] = (char) (c + 'a');
//
//            }
//        }
//        return String.valueOf(cs);
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}
