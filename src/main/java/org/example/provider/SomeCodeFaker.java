package org.example.provider;

import lombok.SneakyThrows;
import net.datafaker.Faker;
import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

import java.nio.file.Paths;
import java.util.Locale;

public class SomeCodeFaker extends Faker {

    public SequentialSomeCodeOfInterest someCodeOfInterest() {
        return getProvider(SequentialSomeCodeOfInterest.class, SequentialSomeCodeOfInterest::new, this);
    }

    public static class SequentialSomeCodeOfInterest extends AbstractProvider<BaseProviders>{
        private static final String KEY = "some-code";
        private static String SOME_CODE = "AA11AA1";
        private static String INITIAL_VALUE = "AA11AA1";

        @SneakyThrows
        public SequentialSomeCodeOfInterest(BaseProviders baseProviders) {
            super(baseProviders);
            baseProviders.addPath(Locale.ENGLISH, Paths.get(this.getClass().getClassLoader().getResource("some_codes.txt").getPath()).toAbsolutePath());
        }

        public String someCode10List(){
            return resolve(KEY + "list-10");
        }

        public String someCode20List(){
            return resolve(KEY + "list-20");
        }

        public void setInitialValue(String initialValue){
            SOME_CODE = initialValue;
        }

        public void setInitialValue(){
            setInitialValue(INITIAL_VALUE);
        }

        public String someCode(){
            char[] charArray = SOME_CODE.toUpperCase().toCharArray();
            for (int i = charArray.length; i >=0 ; i--) {
                if(charArray[i] == 'Z'){
                    charArray[i] = 'A';
                } else if(charArray[i] == '9'){
                    charArray[i] = '0';
                } else {
                    charArray[i]++;
                    break;
                }
            }
            SOME_CODE = new String(charArray);
            return SOME_CODE;
        }
    }
}
