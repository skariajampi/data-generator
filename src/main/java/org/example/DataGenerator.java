package org.example;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class DataGenerator {

    public static SomeDataGen unique(){
        DataGenContext dataGenContext = DataGenContext.builder()
                .someId(DataContextHelper.someId())
                .someValue(DataContextHelper.defaultSomeValue())
                .someDateTime(DataContextHelper.defaultSomeTime())
                .build();
        return new SomeDataGen(dataGenContext);
    }

    public static class SomeDataGen{
        private final DataGenContext dataGenContext;

        private SomeDataGen(DataGenContext dataGenContext) {
            this.dataGenContext = dataGenContext;
        }

        public Tuple2<String, String> getSomeIdAndValue(){
            return Tuple.of(dataGenContext.getSomeId(), dataGenContext.getSomeValue());
        }
    }
}
