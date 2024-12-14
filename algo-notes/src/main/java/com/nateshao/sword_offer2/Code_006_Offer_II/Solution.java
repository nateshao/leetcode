package com.nateshao.sword_offer2.Code_006_Offer_II;

import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2022/10/6 15:08
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,10};
        int target = 8;
        int[] res = twoSum(arr, target);
        for (int re : res) {
            System.out.print(" "+re);
        }
    }
    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        while (left<right){
            int sum  = numbers[left]+numbers[right];
            if (sum>target)right--;
            else if (sum<target)left++;
            else return new int[]{left,right};
            break;
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) return new int[]{low, high};
             else if (sum < target) ++low;
             else --high;
        }
        return new int[]{-1, -1};
    }

    /**最长不重复的子串
     * 滑动窗口+hashset
     * 左，右指针一直向右移动
     * hashset不含有right，就添加进去，right++
     * hashset含有left，移除left，left++；
     * 记录最大值
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right=0,maxNum=0;
        HashSet<Character> res = new HashSet<>();
        while (right<s.length()){
            if (!res.contains(s.charAt(right)))
            {
                res.add(s.charAt(right));
                right++;
            }else {
                res.remove(s.charAt(left));
                left++;
            }
           maxNum = Math.max(maxNum,res.size());
        }
        return maxNum;
    }
}
