package com.nateshao.sword_offer.topic_04_replaceSpace;

/**
 * @date Created by 邵桐杰 on 2021/11/15 23:12
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 替换空格
 */
public class Solution {

    public static void main(String[] args) {
        String str1 = "We Are Happy";
        String str2 = "We Are Happy";
        String str3 = "We Are Happy";
        String s1 = replaceSpace1(str1);
        String s2 = replaceSpace1(str2);
        String s3 = replaceSpace1(str3);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    /**
     * 算法流程：遇到空格则append“%20”，如果不是空格就append字符串中的字符。
     * - 初始化一个 list (Python) / StringBuilder (Java) ，记为 res ；
     * - 遍历列表 s 中的每个字符 c ：
     * - 当 c 为空格时：向 res 后添加字符串 "%20" ；
     * - 当 c 不为空格时：向 res 后添加字符 c ；
     * - 将列表 res 转化为字符串并返回。
     * <p>
     * 复杂度分析：
     * - 时间复杂度 O(N) ： 遍历使用O(N) ，每轮添加（修改）字符操作使用 O(1) ；
     * - 空间复杂度 O(N)：  新建的 StringBuilder 都使用了线性大小的额外空间。
     *
     * @param s
     * @return
     */
    public static String replaceSpace1(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();

//        if (s == null)
//            return null;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (String.valueOf(s.charAt(i)).equals(" ")) {
//                sb.append("%20");
//            } else {
//                sb.append(s.charAt(i));
//            }
//        }
//        return String.valueOf(sb);
    }

    /**
     * 方法二：字符数组
     * 复杂性分析
     * 时间复杂度：O(n)。遍历字符串 s 一遍。
     * 空间复杂度：O(n)。额外创建字符数组，长度为 s 的长度的 3 倍。
     *
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    /**
     * 秀
     *
     * @param s
     * @return
     */
    public String replaceSpace3(String s) {
        return s.replace(" ", "%20");
    }


}
