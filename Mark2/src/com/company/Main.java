package com.company;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String ransomNote = "abl";
        String magazine = "abbagjkjl";

        System.out.println(canConstruct(ransomNote, magazine));
        //canConstruct(ransomNote, magazine);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] notes = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();

        if (notes.length > mag.length) {
            return false;
        }

        //создаем список Character пробегаясь по массиву notes
        List<Character> ransomList = new ArrayList<>();
        for (char temp:notes) {
            ransomList.add((Character) temp);
        }

        //создаем список Character пробегаясь по массиву mag
        List<Character> magList = new ArrayList<>();
        for (char temp:mag) {
            magList.add((Character) temp);
        }

        //создаем список букв из ransom без дубликатов
        Set<Character> ransomSet = new LinkedHashSet<>();
        for (Character temp: ransomList) {
            ransomSet.add(temp);
        }

        //создаем список обЪектов DataOfWord из ransom( у него поля буква и каунтер)
        List<DataOfWord> ransomData = new ArrayList<>();
        for (Character tempSet:ransomSet) {
            ransomData.add(new DataOfWord(tempSet,0));
        }
        //это будут наши данные о количестве буков из ransom
        for (DataOfWord dataTemp:ransomData) {
            for (Character listTemp:ransomList) {
                if(listTemp == dataTemp.getName()) dataTemp.setCounter(dataTemp.getCounter()+1);
            }
        }

        //создаем такой же список DataOfWord для mag
        List<DataOfWord> magData = new ArrayList<>();
        for (Character tempSet:ransomSet){
            magData.add(new DataOfWord(tempSet,0));
        }
        //и так же записываем количесто повторов буков
        for(DataOfWord dataTemp:magData){
            for(Character tempList:magList){
                if(tempList == dataTemp.getName()) dataTemp.setCounter(dataTemp.getCounter()+1);
            }
        }

        //здесь я сделал проверку сколько буков повторяется в одном и другом слове
        System.out.println("ransomData   magData");
        for (int i = 0; i < ransomSet.size(); i++) {
            ransomData.get(i).show();
            System.out.print("        ");
            magData.get(i).show();
            System.out.println();
        }

        //сравнение количества дубликатов ransomData и magData
        for (int i = 0; i < ransomData.size(); i++) {
            //есди количество повторов не равно, метод canConstruct возвращает ложь
            if (ransomData.get(i) != magData.get(i)) return false;
        }



        return true;
    }

    //сделал для удобства работы класс, который в себе как бы хранит представителя буквы
    //и содержит инфу сколько таких представителей
    // чтобы искользовать это пробегая по спискам и записывая счетчик

    static class DataOfWord{
        private char name;
        private int counter;

        DataOfWord(char name, int counter){
            this.name = name;
            this.counter = counter;
        }
        
        public char getName(){
            return this.name;
        }
        
        public int getCounter(){
            return this.counter;
        }
        
        public void setName(char name){
            this.name = name;
        }
        
        public void setCounter(int counter){
            this.counter = counter;
        }

        public void show(){
            System.out.print(this.name + ": " + this.counter + " ");
        }
    }
}