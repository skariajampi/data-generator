package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DataGenContext {

    private String someId;
    private String someValue;
    private String someDateTime;
}
