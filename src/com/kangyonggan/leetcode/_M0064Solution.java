package com.kangyonggan.leetcode;

/**
 * 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * 限制：
 * 1 <= n <= 10000
 *
 * @author kyg
 */
public class _M0064Solution {

    public static void main(String[] args) {
        System.out.println(new _M0064Solution().sumNums(3));
        System.out.println(new _M0064Solution().sumNums(9));
    }

    public int sumNums(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }

}
