package com.nateshao.test.didi_2022_06_11.test1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/6/11 20:05
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        while(cin.hasNextLine())
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            String line = cin.nextLine();
            if (line.length() > 0) {
                String[] arrLine = line.split(" ");
                for (int i=0; i<arrLine.length; i++) {
                    row.add(Integer.parseInt(arrLine[i]));
                }
                arr.add(row);
            }
        }

        new demo1().myFunc(arr);
    }

    public void myFunc(ArrayList<ArrayList<Integer>> arr) {
        // 使用自测数据按钮时调试用，正式提交时要删掉。
        System.out.println(arr);
    }
}
