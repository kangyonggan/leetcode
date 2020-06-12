package com.kangyonggan.leetcode;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author kyg
 */
public class _0015Solution {

    public static void main(String[] args) {
        _0015Solution solution = new _0015Solution();
        List<List<Integer>> result = solution.threeSum(new int[]{-2, -1, 1, 2});
        solution.disp(result);
        result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        solution.disp(result);
        result = solution.threeSum(new int[]{0, 0, 0});
        solution.disp(result);
        result = solution.threeSum(new int[]{-1, 0, 1, 0});
        solution.disp(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        Map<Integer, List<Integer>> idxMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = idxMap.getOrDefault(nums[j], new ArrayList<>());
                if (list.isEmpty()) {
                    list.add(i);
                    list.add(j);
                    idxMap.put(-nums[i] - nums[j], list);
                } else if (list.size() == 2 && !list.contains(j)) {
                    list.add(j);
                    List<Integer> res = new ArrayList<>();
                    for (Integer idx : list) {
                        res.add(nums[idx]);
                    }
                    if (!result.contains(res)) {
                        result.add(res);
                    }
                }
            }
        }

        return result;
    }

    private void disp(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println("==========");
    }
}
