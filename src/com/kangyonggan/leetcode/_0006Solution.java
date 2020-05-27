package com.kangyonggan.leetcode;

import com.sun.tools.javac.util.Assert;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author kyg
 */
public class _0006Solution {

    public static void main(String[] args) {
        String result = new _0006Solution().convert("A", 1);
        System.out.println("结果：" + result);
        // LDREOEIIECIHNTSG
        // LDREOEIIEDIRNTSG
        Assert.check("A".equals(result));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int step = 2 * numRows - 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            boolean flag = false;
            while (true) {
                if (index >= s.length()) {
                    break;
                }
                sb.append(s.charAt(index));

                int offset = step - i * 2;
                if (flag) {
                    offset = step - offset;
                }
                if (offset == 0) {
                    offset = step;
                }
                index += offset;
                flag = !flag;
            }
        }
        return sb.toString();
    }
}
