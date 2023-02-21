package com.nateshao.source.code.java_base.base;

/**
 * @date Created by 邵桐杰 on 2023/2/21 15:09
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class For_qiuhe {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public int getoushu() {
        int sum = 0;                     // 为和赋一个初始值0
        for (int i = 1; i <= 100; i++) { // for循环获取1--100之间的所有数字
            if (i % 2 == 0) {            // if判断其中的偶数是，即获取1--100之间的偶数
                sum += i;                // 将获取的偶数相加sum=sum+i;
            }
        }
        return sum;
    }
}
