package com.kangyonggan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1450. 在既定时间做作业的学生人数
 * 
 * @author kyg
 */
public class Game189_1 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }

        return count;
    }
}
