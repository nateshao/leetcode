package com.nateshao.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/description/
 */
public class Code6_threeSum {
    /**
     * 先将 nums 排序，时间复杂度为 O(NlogN)。
     * <p>
     * 固定 3 个指针中最左（最小）元素的指针 k，双指针 i，j 分设在数组索引 (k,len(nums)) 两端。
     * <p>
     * 双指针 i , j 交替向中间移动，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
     * <p>
     * 1.当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 3 个元素都大于 0 ，在此固定指针 k 之后不可能再找到结果了。
     * 2.当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
     * i，j 分设在数组索引 (k,len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动：
     * 当s < 0时，i += 1并跳过所有重复的nums[i]；
     * 当s > 0时，j -= 1并跳过所有重复的nums[j]；
     * 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode.cn/problems/3sum/solutions/11525/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// 先排序，形成一个递增的数组
        List<List<Integer>> res = new ArrayList<>();
        // k < nums.length - 2是为了保证后面还能存在两个数字
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;// 若nums[k]大于0，则后面的数字也是大于零（排序后是递增的）
            if (k > 0 && nums[k] == nums[k - 1]) continue; // nums[k]值重复了，去重
            // 定义左右指针
            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ; // 左指针前进并去重
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) ; // 右指针后退并去重
                } else {
                    res.add(Arrays.asList(nums[k], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) ; // 左指针前进并去重
                    while (left < right && nums[right] == nums[--right]) ; // 右指针后退并去重
                }
            }
        }
        return res;
    }

    /**
     * 三数之和，排序+双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum2(nums);
        System.out.println(list );
    }
}
















