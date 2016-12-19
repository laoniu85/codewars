package com.laoniu.codewars.Human_Readable_Time;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        if (seconds >= 359999) {
            return "99:59:59";
        }
        // Do something
        int second = seconds % 60;
        int minute = (seconds / 60) % 60;
        int hour = (seconds / 3600);
        if (hour > 99) {
            hour = 99;
        }
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}