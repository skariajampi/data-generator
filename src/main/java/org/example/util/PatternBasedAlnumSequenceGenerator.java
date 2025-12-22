package org.example.util;

public final class PatternBasedAlnumSequenceGenerator implements SequenceGenerator {

    @Override
    public String next(String current) {
        char[] charArray = current.toUpperCase().toCharArray();
        for (int i = charArray.length - 1; i >=0 ; i--) {
            if(charArray[i] == 'Z'){
                charArray[i] = 'A';
            } else if(charArray[i] == '9'){
                charArray[i] = '0';
            } else {
                charArray[i]++;
                break;
            }
        }
        return new String(charArray);
    }
}