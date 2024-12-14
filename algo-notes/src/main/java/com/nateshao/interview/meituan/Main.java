package com.nateshao.interview.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @date Created by 邵桐杰 on 2022/3/5 9:19
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 小美喜欢字母E，讨厌字母F。在小美生日时，小团送了小美一个仅包含字母E和F的字符串，小美想从中选出一个包含字母E数量与字母F数量之差最大的子串。
 *
 * *子串：从字符串前面连续删去若干个字符，从后面连续删去若干个字符剩下的字符串（也可以一个都不删），
 * 例如abcab是fabcab的子串，而不是abcad的子串。我们将空串看作所有字符串的子串。
 *
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        char[] str = br.readLine().trim().toCharArray();
        int maxSum = 0, sum = 0;
        for(int i = 0; i < n; i++){
            if(str[i] == 'E') sum ++;
            if(str[i] == 'F') sum --;
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);
        }
        System.out.println(maxSum);
    }


}
