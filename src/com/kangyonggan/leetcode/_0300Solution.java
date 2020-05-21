package com.kangyonggan.leetcode;

import java.util.Random;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author kyg
 */
public class _0300Solution {

    private static final String DATA = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 50000000; i++) {
            sb.append(DATA.charAt(random.nextInt(DATA.length() - 1)));
        }

        long beginTime = System.currentTimeMillis();
        int len = new _0300Solution().lengthOfLongestSubstring(sb.toString());
        long endTime = System.currentTimeMillis();
        System.out.println(len);

        System.out.println("耗时：" + (endTime - beginTime) + " ms");

        System.out.println(new _0300Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new _0300Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new _0300Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new _0300Solution().lengthOfLongestSubstring(""));
        System.out.println(new _0300Solution().lengthOfLongestSubstring(" "));
        System.out.println(new _0300Solution().lengthOfLongestSubstring("w"));

    }

    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[128];
        int len = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            i = Math.max(m[s.charAt(j)], i);
            len = Math.max(len, j - i + 1);
            m[s.charAt(j)] = j + 1;
        }
        return len;
    }

}
