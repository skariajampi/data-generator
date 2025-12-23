package org.example.util;

import java.util.UUID;

public interface RandomUtil {

    static String getSomeId(){
        return UUID.randomUUID().toString();
    }
}
