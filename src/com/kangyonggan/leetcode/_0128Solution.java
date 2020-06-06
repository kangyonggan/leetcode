package com.kangyonggan.leetcode;

import java.util.Arrays;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author kyg
 */
public class _0128Solution {

    public static void main(String[] args) {
        System.out.println(new _0128Solution().longestConsecutive(new int[]{200, 4, 100, 2, 1, 3}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int maxLen = 1, currLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                currLen++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                if (currLen > maxLen) {
                    maxLen = currLen;
                }
                currLen = 1;
            }
        }
        return Math.max(maxLen, currLen);
    }

}
