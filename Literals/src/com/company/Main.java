package com.company;

public class Main {

    public static void main(String[] args) {

        String ransomNote = "java";
        String magazine = "jar";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] notes = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int maxRepetitionsOfWords = 0; //наибольшее число повторений какой либо буквы из первого слова

        for (int i = 0; i < notes.length; i++) { //пробегаемся по всем буквам первого слова

            int numOfMatches = 0; //создаем локальный счетчик совпадений буквы с буквами второго слова

            for (int j = 0; j < mag.length; j++) { //пробегаемся и сравниваем эту букву с буквами второго слова
                if (notes[i] == mag[j]) numOfMatches++;// если буквы совпадают, увеличиваем локальный счетчик
            }

            //если локальный счетчик больше максимального счетчика - присаиваем его значение максимальному
            //так мы получим в конце наибольшее количество повторений какой то буквы за всю проверку
            if (numOfMatches > maxRepetitionsOfWords) maxRepetitionsOfWords = numOfMatches;
        }

        System.out.println("Наибольшее количество повторений: " + maxRepetitionsOfWords);
        System.out.println("Длина тестового слова: " + notes.length);

        /*
        получается что если бука из первого слова ни разу не нашла себе такую же во втором будет 0
        если нашла несколько раз  то больше 1
        и  любом случае задача выполняется. т.к  в задаче написано что каждая буква тестового слова
        должна совпадать только 1 раз пробегаясь по всему второму слову
         */

        return (maxRepetitionsOfWords == 1);
    }
}

