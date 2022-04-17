package com.company;

public class Main {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;

        Main main = new Main();
        int[] indexes = main.twoSum(nums, target);
        System.out.println(indexes[0] + ", " + indexes[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(nums[i] + nums[j] == target) {
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }


        return temp;
    }
}
