package com.kangyonggan.leetcode;

import java.util.Random;

/**
 * 力扣工具
 *
 * @author kyg
 */
public final class LeetCodeUtil {

    private static final ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 开始计时
     */
    public static void beginTime() {
        THREAD_LOCAL.set(System.currentTimeMillis());
    }

    /**
     * 结束计时
     *
     * @return
     */
    public static long endTime() {
        long beginTime = THREAD_LOCAL.get();
        THREAD_LOCAL.remove();
        return System.currentTimeMillis() - beginTime;
    }

    /**
     * 随机生成长度为len的数字字符串
     *
     * @param len
     * @return
     */
    public static String randomNumber(int len) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 随机生成长度为len的小写字母字符串
     *
     * @param len
     * @return
     */
    public static String randomLowercase(int len) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append((char) (97 + random.nextInt(26)));
        }
        return sb.toString();
    }

    /**
     * 随机生成长度为len的大写字母字符串
     *
     * @param len
     * @return
     */
    public static String randomUppercase(int len) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append((char) (65 + random.nextInt(26)));
        }
        return sb.toString();
    }

    /**
     * 随机生成长度为len的纯字母字符串（大小写混合）
     *
     * @param len
     * @return
     */
    public static String randomLetter(int len) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append((char) ((random.nextBoolean() ? 65 : 97) + random.nextInt(26)));
        }
        return sb.toString();
    }

    /**
     * 随机生成长度为len的字母+数字
     *
     * @param len
     * @return
     */
    public static String randomNumberLetter(int len) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                sb.append((char) ((random.nextBoolean() ? 65 : 97) + random.nextInt(26)));
            } else {
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }

}
