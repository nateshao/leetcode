package com.nateshao.one_question_per_day.code_2022.july;

/**
 * @date Created by 邵桐杰 on 2022/7/1 21:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class Code_07_01_jump {
    /**
     * 常规的思维就是暴力穷举，把所有可行的跳跃方案都穷举出来，计算步数最少的。
     * 穷举的过程会有重叠子问题，用备忘录消除一下，就成了自顶向下的动态规划。
     *
     * 不过直观地想一想，似乎不需要穷举所有方案，只需要判断哪一个选择最具有「潜力」即可，
     * 这就是贪心思想来做，比动态规划效率更高。
     *
     * 显然应该跳 2 步调到索引 2，因为 nums[2] 的可跳跃区域涵盖了索引区间 [3..6]，比其他的都大。
     * 这就是思路，我们用 i 和 end 标记了可以选择的跳跃步数，farthest 标记了所有选择 [i..end]
     * 中能够跳到的最远距离，jumps 记录跳跃次数。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
