package com.kangyonggan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1451. 重新排列句子中的单词
 *
 * @author kyg
 */
public class Game189_2 {

    public static void main(String[] args) {
        System.out.println(new Game189_2().arrangeWords("Keep calm and code on"));
    }

    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] words = text.split(" ");
        Arrays.sort(words, Comparator.comparingInt(String::length));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                word = words[i].substring(0, 1).toUpperCase();
                if (words[i].length() > 1) {
                    word += words[i].substring(1);
                }
            }
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
