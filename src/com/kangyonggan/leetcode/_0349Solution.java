package com.kangyonggan.leetcode;

import com.sun.tools.javac.util.Assert;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * @author kyg
 */
public class _0349Solution {

    public static void main(String[] args) {
        _0349Solution solution = new _0349Solution();
        Assert.check("asas".equals(solution.decodeString("2[as]")));
        Assert.check("aaabcbc".equals(solution.decodeString("3[a]2[bc]")));
        Assert.check("accaccacc".equals(solution.decodeString("3[a2[c]]")));
        Assert.check("abcabccdcdcdef".equals(solution.decodeString("2[abc]3[cd]ef")));
    }

    public String decodeString(String s) {
        // TODO
        return s;
    }

}
