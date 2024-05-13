package com.example.weatheroptimizer.util;

import java.time.LocalDateTime;

public class CustomDateTimeFormatter {

    public static final java.time.format.DateTimeFormatter FORMATTER = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getFormattedDateTime(LocalDateTime dateTime) {
        return FORMATTER.format(dateTime);
    }
}

