package com.kangyonggan.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字
 * 母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * 示例 1：
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 提示：
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 *
 * @author kyg
 */
public class _1371Solution {

    private static final String DATA = "qwertyuiopasdfghjklzxcvbnm";

    public static void main(String[] args) {
        System.out.println(new _1371Solution().findTheLongestSubstring("amntyyaw"));
        System.out.println(new _1371Solution().findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(new _1371Solution().findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(new _1371Solution().findTheLongestSubstring(""));
        System.out.println(new _1371Solution().findTheLongestSubstring("a"));
        System.out.println(new _1371Solution().findTheLongestSubstring("w"));

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 500000; i++) {
            sb.append(DATA.charAt(random.nextInt(DATA.length() - 1)));
        }

        long beginTime = System.currentTimeMillis();
        int len = new _1371Solution().findTheLongestSubstring(sb.toString());
        long endTime = System.currentTimeMillis();
        System.out.println(len);

        System.out.println("耗时：" + (endTime - beginTime) + " ms");
    }

    public int findTheLongestSubstring(String s) {
        int[] idx = new int[32];
        idx[0] = 1;

        int maxLen = 0;
        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= 1;
            } else if (ch == 'e') {
                status ^= 2;
            } else if (ch == 'i') {
                status ^= 4;
            } else if (ch == 'o') {
                status ^= 8;
            } else if (ch == 'u') {
                status ^= 16;
            }

            if (idx[status] == 0) {
                idx[status] = i + 1;
            } else {
                if (status == 0) {
                    maxLen = Math.max(maxLen, i + 2 - idx[status]);
                } else {
                    maxLen = Math.max(maxLen, i + 1 - idx[status]);
                }
            }
        }

        return maxLen;
    }

}
