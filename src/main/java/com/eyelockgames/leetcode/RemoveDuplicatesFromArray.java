package com.eyelockgames.leetcode;

public class RemoveDuplicatesFromArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int k = 0;
        int i = 0;
        while ( i + 1 < nums.length) {
            if (nums[i] != nums[i + 1]) {
                k = k + 1;
                nums[k] = nums[i + 1];
                i = i + 1;
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] threeNums = { 1, 1, 2 };
        int num = removeDuplicates(threeNums);
        System.out.println("results: " + num);
        int[] threeMoreNums = { -100, 0, 100 };
        num = removeDuplicates(threeMoreNums);
        System.out.println("results: " + num);
    }
}
