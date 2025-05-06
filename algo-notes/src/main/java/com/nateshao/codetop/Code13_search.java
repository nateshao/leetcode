package com.nateshao.codetop;

public class Code13_search {
    /**
     * 33. 搜索旋转排序数组
     * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
     *
     * @param nums
     * @param target
     * @return
     */
//    public int search(int[] nums, int target) {
//        int lo = 0, hi = nums.length - 1;
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
//                lo = mid + 1;
//            } else {
//                hi = mid;
//            }
//        }
//        return lo == hi && nums[lo] == target ? lo : -1;
//    }

//    public int search(int[] nums, int target) {
//        if (nums.length == 0 || nums == null) return -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) return i;
//        }
//        return -1;
//    }

    /**
     * 二分查找
     * 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段，
     * 接下来再判断 target 是在 mid 的左边还是右边，从而来调整左右边界 lo 和 hi。
     * <p>
     * 作者：Sweetiee 🍬
     * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/221435/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0, hight = nums.length - 1, mid = 0;
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[low] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[low]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[low] && target < nums[mid]) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hight]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int low = 0, hight = nums.length - 1, mid = 0;
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[mid] && target < nums[mid]) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[mid]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }

}
