package com.systelab.kata;

import java.util.ArrayList;
import java.util.Arrays;

public class MexicanWave {
    public static String[] wave(String str) {
        ArrayList<String> wave = new ArrayList<>(Arrays.asList());
        for(int i=0;i<str.length();i++){
            StringBuilder textWave = new StringBuilder(str);
            char letter = textWave.charAt(i);
            if (letter!= ' '){
                textWave.setCharAt(i, java.lang.Character.toUpperCase(letter));
                wave.add(textWave.toString());
            }
        }

        return  wave.stream().toArray(String[]::new);
    }
}
