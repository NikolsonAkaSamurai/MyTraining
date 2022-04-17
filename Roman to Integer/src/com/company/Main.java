package com.company;

import java.awt.datatransfer.FlavorTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String date = "MCMXCIV";
        System.out.println(main.romanToInt(date));
    }

    public int romanToInt(String s) {
        char[] romanSymbols = s.toCharArray();
        char[] reverseRoman = new char[romanSymbols.length];
        for (int i = 0; i < romanSymbols.length; i++) {
            reverseRoman[(romanSymbols.length-1) - i] = romanSymbols[i];
        }

        int oldNum = 0;
        int result = 0;
        for(char temp: reverseRoman){
            pairsOfNums pair = pairsOfNums.valueOf(Character.toString(temp));
            if(oldNum > pair.getValue()) result -= pair.getValue();
                else{
                result += pair.getValue();
                oldNum = pair.getValue();
                }

        }
        return result;
    }

    enum pairsOfNums{
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        private int value;

        pairsOfNums(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }
}
