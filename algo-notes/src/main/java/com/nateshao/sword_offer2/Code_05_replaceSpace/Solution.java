package com.nateshao.sword_offer2.Code_05_replaceSpace;

/**
 * @date Created by 邵桐杰 on 2022/3/5 21:35
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Solution {
    public static void main(String[] args) {
        String s = "We are happy";
        System.out.println("replaceSpace(s) = " + replaceSpace(s));
        System.out.println("replaceSpace2(s) = " + replaceSpace2(s));
    }

    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 初始化一个 StringBuilder，记为 res ；
     * 遍历列表 s 中的每个字符 c ：
     * 当 c 为空格时：向 res 后添加字符串 "%20" ；
     * 当 c 不为空格时：向 res 后添加字符 c ；
     * 将列表 res 转化为字符串并返回。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-ji-jian-qing-xi-tu-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

    public static String replaceSpace3(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar==' ') res.append("%20");
            else res.append(aChar);
        }
        return res.toString();
    }
}
