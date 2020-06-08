package com.kangyonggan.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 * 示例 1：
 * <p>
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 * <p>
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 * <p>
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * 提示：
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 *
 * @author kyg
 */
public class _0990Solution {

    public static void main(String[] args) {
        _0990Solution solution = new _0990Solution();
        System.out.println(solution.equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"}));// false
        System.out.println(solution.equationsPossible(new String[]{"c==c", "f!=a", "f==b", "b==c"}));// true
        System.out.println(solution.equationsPossible(new String[]{"a==b", "b!=a"}));// false
        System.out.println(solution.equationsPossible(new String[]{"b==a", "a==b"}));// true
        System.out.println(solution.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));// true
        System.out.println(solution.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));// false
        System.out.println(solution.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));// true
    }

    public boolean equationsPossible(String[] equations) {
        List<Set<Character>> list = new ArrayList<>();
        char ch1, ch2;
        boolean contains;

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                ch1 = equations[i].charAt(0);
                ch2 = equations[i].charAt(3);
                contains = false;

                Set<Character> mergeSet = new HashSet<>();
                for (int j = 0; j < list.size(); j++) {
                    Set<Character> set = list.get(j);
                    if (set.contains(ch1) || set.contains(ch2)) {
                        set.add(ch1);
                        set.add(ch2);
                        mergeSet.addAll(set);
                        set.clear();
                        contains = true;
                    }
                }
                list.add(mergeSet);
                if (!contains) {
                    Set<Character> set = new HashSet<>();
                    set.add(ch1);
                    set.add(ch2);
                    list.add(set);
                }
            }
        }
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                ch1 = equations[i].charAt(0);
                ch2 = equations[i].charAt(3);

                if (ch1 == ch2) {
                    return false;
                }

                for (int j = 0; j < list.size(); j++) {
                    Set<Character> set = list.get(j);
                    if (set.contains(ch1) && set.contains(ch2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
