package com.nateshao.interview.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @date Created by 邵桐杰 on 2022/3/5 9:22
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 服装店新进了a条领带，b条裤子，c个帽子，d件衬衫，现在要把这些搭配起来售卖。
 * 有三种搭配方式，一条领带和一件衬衫，一条裤子和一件衬衫，一个帽子和一件衬衫。
 * 卖出一套领带加衬衫可以得到e元，卖出一套裤子加衬衫可以得到f元，卖出一套帽子加衬衫可以得到g元。
 * 现在你需要输出最大的获利方式
 */
public class MaxProfix {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] params = br.readLine().trim().split(" ");
            int a = Integer.parseInt(params[0]);
            int b = Integer.parseInt(params[1]);
            int c = Integer.parseInt(params[2]);
            int d = Integer.parseInt(params[3]);
            int e = Integer.parseInt(params[4]);
            int f = Integer.parseInt(params[5]);
            int g = Integer.parseInt(params[6]);
            // 将三种搭配放入一个大根堆中，按照三种搭配的获利对搭配进行降序排列
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            maxHeap.offer(new int[]{a, e});
            maxHeap.offer(new int[]{b, f});
            maxHeap.offer(new int[]{c, g});
            // 把衬衫分配给领带、裤子和帽子中赚钱多的
            long money = 0;
            while(!maxHeap.isEmpty() && d > 0){
                int[] temp = maxHeap.poll();
                money += (long)Math.min(temp[0], d) * temp[1];
                d -= temp[0];
            }
            System.out.println(money);
        }
    }


