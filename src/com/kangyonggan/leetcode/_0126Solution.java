package com.kangyonggan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * @author kyg
 */
public class _0126Solution {

    public static void main(String[] args) {
        _0126Solution solution = new _0126Solution();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        List<List<String>> result = solution.findLadders("hit", "cog", wordList);
        for (List<String> list : result) {
            for (String word : list) {
                System.out.print(word + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");

        wordList.clear();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        result = solution.findLadders("hit", "cog", wordList);
        for (List<String> list : result) {
            for (String word : list) {
                System.out.print(word + "\t");
            }
            System.out.println();
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        return result;
    }

}
