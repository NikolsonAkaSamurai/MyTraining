package com.company;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        Main main = new Main();
        main.longestCommonPrefix(strs);


    }

    public String longestCommonPrefix(String[] strs) {
        int needRepetitions = strs.length;
        String repetitionsWords = "";
        Set<Character> repitList = new LinkedHashSet<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                repitList.add((Character) strs[i].charAt(j));
            }
        }
        List<Character> repitArrayList = new ArrayList<>();
        for(Character temp: repitList){
            repitArrayList.add(temp);
        }

        DataOfWord[] dataOfWords = new DataOfWord[repitList.size()];
        for (int i = 0; i < dataOfWords.length; i++) {
            dataOfWords[i] = new DataOfWord(repetitionsWords.);
        }

//        for(Character temp:repitList){
//            System.out.print(temp);
//        }

        return "";
    }

    class DataOfWord{
        private char name;
        private int counter;

        DataOfWord(){}

        DataOfWord(char name, int counter){
            this.name = name;
            this.counter = counter;
        }

        public char getName() {
            return name;
        }

        public void setName(char name) {
            this.name = name;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }
}
