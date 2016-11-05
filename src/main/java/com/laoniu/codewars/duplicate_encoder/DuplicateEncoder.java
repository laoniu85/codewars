package com.laoniu.codewars.duplicate_encoder;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {

    public static Map<String, Integer> countLetter(String word) {
        Map<String, Integer> integerMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            String ch = word.substring(i, i + 1).toLowerCase();
            integerMap.putIfAbsent(ch, 0);
            integerMap.put(ch, integerMap.get(ch) + 1);
        }

        return integerMap;

    }

    static String encode(String word) {
        Map<String, Integer> integerMap = countLetter(word);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append(integerMap.get(word.substring(i, i + 1).toLowerCase()) > 1 ? ")" : "(");
        }
        return stringBuilder.toString();
    }
}
