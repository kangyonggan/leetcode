package com.kangyonggan.leetcode;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * @author kyg
 */
public class _0008Solution {

    public static void main(String[] args) {
        _0008Solution solution = new _0008Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("  -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("91283472332"));
        System.out.println(solution.myAtoi("3.14"));
        System.out.println(solution.myAtoi(".14"));
        System.out.println(solution.myAtoi("-"));
        System.out.println(solution.myAtoi("89-"));
        System.out.println(solution.myAtoi("89-11"));
        System.out.println(solution.myAtoi("0-11"));
        System.out.println(solution.myAtoi("89."));
        System.out.println(solution.myAtoi("+8"));
        System.out.println(solution.myAtoi("-+-8"));
        System.out.println(solution.myAtoi("9223372036854775808"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("-2147483647"));
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("-2147483648"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        int num = 0;
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '-' && ch != '+' && (ch < '0' || ch > '9')) {
                break;
            }
            if ('-' == ch) {
                if (i == 0) {
                    isNegative = true;
                    continue;
                } else {
                    break;
                }
            }
            if (ch == '+') {
                if (i == 0) {
                    continue;
                } else {
                    break;
                }
            }
            if (num * 10L + ch - 48 > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + ch - 48;
        }

        return isNegative ? -num : num;
    }

}
