package com.sic.marktory.common;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

// 2024-04-15 15:10:55 형식으로 변환
public class DateTimeUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final ZoneId zone = ZoneId.of("Asia/Seoul");

    public static String nowFormatted() {
        return formatter.format(ZonedDateTime.ofInstant(Instant.now(), zone));
    }

    public static String format(Instant instant) {
        return formatter.format(ZonedDateTime.ofInstant(instant, zone));
    }
}
