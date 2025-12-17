package org.example.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public interface TimeUtil {

    DateTimeFormatter STANDARD_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    static OffsetDateTime nowUTC(){
        return OffsetDateTime.now(ZoneOffset.UTC);
    }

    static String nowUTCString(){
        return nowUTC().format(STANDARD_DATE_TIME_FORMATTER);
    }
}
