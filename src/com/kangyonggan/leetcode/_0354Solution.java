package com.kangyonggan.leetcode;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另
 * 一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，
 * 如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另
 * 一个信封里面）。
 * 说明:不允许旋转信封。
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * @author kyg
 */
public class _0354Solution {

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(new _0354Solution().maxEnvelopes(envelopes));

        int[][] envelopes2 = {{30, 50}, {12, 2}, {3, 4}, {12, 15}};
        System.out.println(new _0354Solution().maxEnvelopes(envelopes2));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] o1, int[] o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int i = 0; i < envelopes.length; i++) {
            System.out.print("[" + envelopes[i][0] + "," + envelopes[i][1] + "]\t");
        }
        System.out.println();

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        for (int i = 0; i < height.length; i++) {
            System.out.print(height[i] + "\t");
        }
        System.out.println();

        return lenOfMaxSubInc(height);
    }

    private int lenOfMaxSubInc(int[] arr) {
        // TODO
        return 0;
    }

}
