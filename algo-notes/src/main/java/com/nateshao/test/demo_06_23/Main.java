package com.nateshao.test.demo_06_23;

/**
 * @date Created by 邵桐杰 on 2022/6/23 17:13
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        String s = "HelloWorld";
        // olleHdlroW
    }

    /**
     * 输入一个字符串
     * 输出以单词维度的反转
     *
     * 思路1:栈
     *
     * 思路2：递归
     * 1，转成字符，遍历
     * 调用递归反转，以单词的首字符大写为划分
     *
     * @param s
     * @return
     */
    public String reverseString(String s){
        //
        StringBuilder sb = new StringBuilder(s);
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            // 两个大写之间的
            if (s.charAt(i) =='A'||s.charAt(i)=='Z' ){//todo
                // 反转
//                sb.reverse();

            }
        }


        return "";
    }
}
