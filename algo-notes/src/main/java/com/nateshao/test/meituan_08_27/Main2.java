package com.nateshao.test.meituan_08_27;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/8/27 16:09
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 小美有一个精致的珠宝链子。初始这个链子上有n个宝石，从左到右分别编号为1~n
 * （宝石上的编号不会因为交换位置而改变编号）。
 * 接着，小美为了美观对这个项链进行微调，
 * 有m次操作，每次选择一个编号 x ,
 * 将编号 x 的宝石放到最左边（不改变其他宝石的相对位置）。
 * 小美想知道，所有操作完成后最终链子从左到右宝石编号是多少。
 */
public class Main2 {
    public static void main(String[] args) {
        int[] nums = {5,3,2,3,4};
        int[] arr = getArr(nums);
        System.out.println(arr.toString());
    }
    public static int[] getArr(int[] nums) {
        int[] res = null;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            list.add(i);
        }
        list.remove(list.get(nums.length-1));
        for (int num : nums) {
          res[num] = list.get(num);
        }
        return res;
    }
}





















