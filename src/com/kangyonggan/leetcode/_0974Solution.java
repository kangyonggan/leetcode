package com.kangyonggan.leetcode;

/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 提示：
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 * @author kyg
 */
public class _0974Solution {

    public static void main(String[] args) {
        int[] a = {4, 5, 0, -2, -3, 1};
        System.out.println(new _0974Solution().subarraysDivByK(a, 5));
    }

    public int subarraysDivByK(int[] A, int K) {
        int[] modCnt = new int[K];
        modCnt[0] = 1;

        int sum = 0;
        for (int num : A) {
            sum += num;
            int mod = Math.floorMod(sum, K);
            modCnt[mod]++;
        }

        int result = 0;
        for (int cnt : modCnt) {
            result += cnt * (cnt - 1) / 2;
        }

        return result;
    }

}
