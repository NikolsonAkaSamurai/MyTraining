package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int x = 33233;
        System.out.println(main.isPalindrome(x));

    }

    public boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        char[] array = num.toCharArray();
        Character[] array2 = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[(array2.length-1)-i] = (Character) array[i];
            System.out.print(array[(array2.length-1)-i]);
        }
        Character[] array3 = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            array3[i] = (Character) array[i];
        }

        for (int i = 0; i < array.length; i++) {
            if(array2[i] != array3[i]) return false;
        }

        return true;
    }
}
