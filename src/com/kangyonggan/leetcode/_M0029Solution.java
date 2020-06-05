package com.kangyonggan.leetcode;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author kyg
 */
public class _M0029Solution {
    public static void main(String[] args) {
        int[] result = new _M0029Solution().spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        });
        for (int a : result) {
            System.out.print(a + "\t");
        }
        System.out.println();
        result = new _M0029Solution().spiralOrder(new int[][]{
                {1, 2, 3, 5}, {5, 6, 7, 8}, {9, 10, 11, 12}
        });
        for (int a : result) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int i = 0, j = 0, k = 0, direction = 0;
        while (k < result.length) {
            result[k++] = matrix[i][j];
            matrix[i][j] = Integer.MAX_VALUE;
            if (direction == 0) {
                if (j + 1 < matrix[0].length && matrix[i][j + 1] != Integer.MAX_VALUE) {
                    j++;
                } else {
                    direction = 1;
                    i++;
                }
            } else if (direction == 1) {
                if (i + 1 < matrix.length && matrix[i + 1][j] != Integer.MAX_VALUE) {
                    i++;
                } else {
                    direction = 2;
                    j--;
                }
            } else if (direction == 2) {
                if (j - 1 >= 0 && matrix[i][j - 1] != Integer.MAX_VALUE) {
                    j--;
                } else {
                    direction = 3;
                    i--;
                }
            } else if (direction == 3) {
                if (i - 1 >= 0 && matrix[i - 1][j] != Integer.MAX_VALUE) {
                    i--;
                } else {
                    direction = 0;
                    j++;
                }
            }
        }

        return result;
    }
}
