package com.kangyonggan.leetcode;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * @author kyg
 */
public class _0010Solution {
    public static void main(String[] args) {
        _0010Solution solution = new _0010Solution();
        System.out.println(solution.isMatch("aa", "a"));// false
        System.out.println(solution.isMatch("aa", "a*"));// true
        System.out.println(solution.isMatch("ab", ".*"));// true
        System.out.println(solution.isMatch("aab", "c*a*b"));// true
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));// false
        System.out.println(solution.isMatch("aaa", ".*"));// true
        System.out.println(solution.isMatch("a", "ab"));// true
        System.out.println(solution.isMatch("ab", ".*c"));// false
    }

    public boolean isMatch(String s, String p) {
        // TODO
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int sStart, int pStart) {
        if (sStart == s.length()) {
            return true;
        }
        if (pStart >= p.length()) {
            return false;
        }
        char chS = s.charAt(sStart);
        char chP = p.charAt(pStart);
        boolean isAny = chP == '.';
        if (chP >= 'a' && chP <= 'z' || isAny) {
            if (pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
                if ((chP == chS || isAny) && pStart + 2 <= p.length()) {
                    for (int i = sStart; i < s.length(); i++) {
                        if (chP == s.charAt(i) || isAny) {
                            if (isMatch(s, p, i + 1, pStart + 2)) {
                                return true;
                            }
                            isAny = false;
                            chP = chS;
                        } else {
                            break;
                        }
                    }
                } else {
                    // * == 0
                    return isMatch(s, p, sStart, pStart + 2);
                }
            } else {
                if (chP == chS || isAny) {
                    return isMatch(s, p, sStart + 1, pStart + 1);
                } else {
                    return false;
                }
            }
        }

        return false;
    }
}
