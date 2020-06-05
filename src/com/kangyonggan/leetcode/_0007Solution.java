package com.kangyonggan.leetcode;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author kyg
 */
public class _0007Solution {
    public static void main(String[] args) {
        _0007Solution solution = new _0007Solution();

        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(-120));
        System.out.println(solution.reverse(1));
        System.out.println(solution.reverse(999));
        System.out.println(solution.reverse(2147483639));
        System.out.println(solution.reverse(-1563847412));
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        long result = 0L;
        while (Math.abs(x) > 9) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        result = result * 10 + x % 10;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
