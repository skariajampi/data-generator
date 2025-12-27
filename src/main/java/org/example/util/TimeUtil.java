package org.example.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public interface TimeUtil {

    DateTimeFormatter STANDARD_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    static OffsetDateTime nowUTC(){
        return OffsetDateTime.now(ZoneOffset.UTC);
    }

    static String nowUTCString(){
        return nowUTC().format(STANDARD_DATE_TIME_FORMATTER);
    }

    static String nowMinusDaysInUTCString(int days){
        return nowUTC().minusDays(days).format(STANDARD_DATE_TIME_FORMATTER);
    }

    static String nowPlusDaysInUTCString(int days){
        return nowUTC().plusDays(days).format(STANDARD_DATE_TIME_FORMATTER);
    }

    static String givenDateTimeUTC(int year, int month, int dayOfMonth, int hourOfDay, int minute){
        int randomSecond = ThreadLocalRandom.current().nextInt(0, 59);
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, hourOfDay, minute, randomSecond);
        return dateTime.atOffset(ZoneOffset.UTC).format(STANDARD_DATE_TIME_FORMATTER);
    }

    static String givenDateTimeUTC(int year, int month, int dayOfMonth, int hourOfDay){
        int randomMinute = ThreadLocalRandom.current().nextInt(0, 59);
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, hourOfDay, randomMinute);
        return dateTime.atOffset(ZoneOffset.UTC).format(STANDARD_DATE_TIME_FORMATTER);
    }
}
