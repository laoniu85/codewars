package com.laoniu.codewars.merged_string_checker;

public class StringMerger {

    public static boolean isMerge(String s, String part1, String part2) {
        System.out.println(String.format("%s,%s,%s",s,part1,part2));
        return realMerge(s, part1, part2);
    }

    public static boolean realMerge(String s, String part1, String part2) {
        if (s.equals(part1 + part2) || s.equals(part2 + part1)) {
            return true;
        }

        if (part1.length() > 0 && s.length() > 0 &&
                isEqualsFirst(s, part1)
                && realMerge(s.substring(1), part1.substring(1), part2)) {
            return true;
        }
        if (part2.length() > 0 && s.length() > 0 &&
                isEqualsFirst(s, part2) &&
                realMerge(s.substring(1), part1, part2.substring(1))) {
            return true;
        }
        return false;
    }

    private static boolean isEqualsFirst(String s, String part1) {
        return s.substring(0, 1).equals(part1.substring(0, 1));
    }

}