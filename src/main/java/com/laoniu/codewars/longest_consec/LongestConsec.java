package com.laoniu.codewars.longest_consec;

import java.util.Arrays;

class LongestConsec {

    public static int lengthConsec(String[] strarr, int start, int k) {
        int sum = 0;
        for (int i = 0; i < k && (start + i < strarr.length); i++) {
            sum += strarr[start + i].length();
        }
        return sum;
    }

    public static int longest(String[] strarr, int k) {
        int maxLen = 0;
        int maxLenIdx = -1;
        for (int i = 0; i < strarr.length; i++) {
            int len = lengthConsec(strarr, i, k);
            if (len > maxLen) {
                maxLenIdx = i;
                maxLen = len;
            }
        }
        return maxLenIdx;
    }

    public static String longestConsec(String[] strarr, int k) {
        // your code
        if (strarr.length == 0 || k > strarr.length || k <= 0) {
            return "";
        }
        int longest = longest(strarr, k);
        return String.join("", Arrays.asList(strarr).subList(longest, longest + k));
    }
}