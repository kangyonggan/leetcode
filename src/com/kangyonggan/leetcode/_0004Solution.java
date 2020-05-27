package com.kangyonggan.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author kyg
 */
public class _0004Solution {

    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(new _0004Solution().findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int j = 0, k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k >= nums2.length || (j < nums1.length && nums1[j] < nums2[k])) {
                nums[i] = nums1[j++];
            } else {
                nums[i] = nums2[k++];
            }
        }

        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }
        return nums[nums.length / 2];
    }
}
