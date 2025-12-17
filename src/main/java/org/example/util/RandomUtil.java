package org.example.util;

import java.util.UUID;

public interface RandomUtil extends TimeUtil {

    static String getSomeId(){
        return UUID.randomUUID().toString();
    }
}
