package com.nateshao.codetop;

import java.util.LinkedList;
import java.util.List;

public class Code16_permute {
    /**
     * 46. 全排列
     * https://leetcode.cn/problems/permutations/description/
     * <p>
     * https://labuladong.online/algo/images/subset/3.jpg
     * <p>
     * labuladong
     *
     * @param nums
     * @return
     */
//    List<List<Integer>> res = new LinkedList<>();
//    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
//    public List<List<Integer>> permute(int[] nums) {
//        // 记录「路径」
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(nums, track);
//        return res;
//    }
//
//    void backtrack(int[] nums, LinkedList<Integer> track) {
//        // 触发结束条件
//        if (track.size() == nums.length) {
//            res.add(new LinkedList(track));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            // 排除不合法的选择
//            if (track.contains(nums[i])) {
//                continue;
//            }
//            // 做选择
//            track.add(nums[i]);
//            // 进入下一层决策树
//            backtrack(nums, track);
//            // 取消选择
//            track.removeLast();
//        }
//    }
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

}
