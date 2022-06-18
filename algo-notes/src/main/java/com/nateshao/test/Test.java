package com.nateshao.test;

import org.checkerframework.checker.units.qual.C;

import java.util.Objects;

/**
 * @date Created by 邵桐杰 on 2022/5/9 12:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        int a = 0, c = 0;
        do{
            --c;
            a=a-1;

        }while (a>0);
        System.out.println(c);
    }
    // 使用标准SQL嵌套语句查询选修课程名称为'税收基础’的学员学号和姓名。
    // --实现代码：
    //SELECT SN,SD FROM
    //WHERE [S#] IN(
    //SELECT [S#] FROM C,SC
    //WHERE C.[C#]=SC.[C#]
    //AND CN=N'税收基础')

//
//    --实现代码：
//    SELECT S.SN,S.SD FROM S,SC
//    WHERE S.[S#]=SC.[S#]
//    AND SC.[C#]='C2'[@more@]

    //SELECT `S#`,`SN` FROM s WHERE `S#` in (SELECT `S#` FROM sc GROUP BY `S#`
    //HAVING COUNT(*) = (SELECT COUNT(*) FROM c))
}
