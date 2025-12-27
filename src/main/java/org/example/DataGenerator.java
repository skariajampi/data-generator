package org.example;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import org.example.util.SomeCodeUtil;

public class DataGenerator {

    /**
     * Creates a DataGenContext with sequential code from YAML-based sequence
     */
    public static SomeDataGen unique(){
        DataGenContext dataGenContext = DataGenContext.builder()
                .someId(DataContextHelper.someId())
                .someDateTime(DataContextHelper.defaultSomeTime())
                .build();
        return new SomeDataGen(dataGenContext);
    }

    /**
     * Creates a DataGenContext with sequential code from YAML-based sequence
     */
    public static SomeDataGen havingContext(DataGenContext dataGenContext){
        return new SomeDataGen(dataGenContext);
    }

    /**
     * Creates a DataGenContext with sequential code from YAML-based sequence
     **/
    public static SomeDataGen contextWithSomeCode(){
        DataGenContext dataGenContext = DataGenContext.builder()
                .someId(DataContextHelper.someId())
                .someValue(DataContextHelper.nextSomeCode())
                .someDateTime(DataContextHelper.defaultSomeTime())
                .build();
        return new SomeDataGen(dataGenContext);
    }

    /**
     * Creates a DataGenContext with sequential code from YAML-based sequence
     */
    public static SomeDataGen contextStartingFromYamlInitial(){
        DataContextHelper.resetSomeCodeSequence();
        return contextWithSomeCode();
    }

    /**
     * Creates a DataGenContext with custom value
     */
    public static SomeDataGen contextWithValue(String code){
        DataGenContext dataGenContext = DataGenContext.builder()
                .someId(DataContextHelper.someId())
                .someValue(code)
                .someDateTime(DataContextHelper.defaultSomeTime())
                .build();
        return new SomeDataGen(dataGenContext);
    }

    /**
     * Creates a DataGenContext with list of 10 from YAML filr
     */
    public static SomeDataGen contextWithList10(String code){
        DataGenContext dataGenContext = DataGenContext.builder()
                .someId(DataContextHelper.someId())
                .someValue(SomeCodeUtil.list10())
                .someDateTime(DataContextHelper.defaultSomeTime())
                .build();
        return new SomeDataGen(dataGenContext);
    }

    /**
     * Creates a DataGenContext with list of 20 from YAML filr
     */
    public static SomeDataGen contextWithList20(String code){
        DataGenContext dataGenContext = DataGenContext.builder()
                .someId(DataContextHelper.someId())
                .someValue(SomeCodeUtil.list20())
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

        public Tuple3<String, String, String> buildSomeData(){
            return Tuple.of(dataGenContext.getSomeId(), buildSomeOtherData(), buildSomeOtherData2());
        }

        private String buildSomeOtherData() {
            return dataGenContext.getSomeValue() + " " + dataGenContext.getSomeDateTime();
        }

        private String buildSomeOtherData2() {
            return dataGenContext.getSomeValue() + " " + dataGenContext.getSomeDateTime();
        }
    }
}
