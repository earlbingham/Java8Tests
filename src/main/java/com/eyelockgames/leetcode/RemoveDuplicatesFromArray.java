package com.eyelockgames.leetcode;

public class RemoveDuplicatesFromArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int k = 0;
        for (int i = 0; i + 1 < nums.length; ) {
            if (nums[i] != nums[i + 1] && k != i) {
                k = k + 1;
                nums[k] = nums[i + 1];
                i = i + 1;
            }
            while (nums[i] == nums[i + 1]) {
                i++;
                if (i + 1 >= nums.length) {
                    break;
                }
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] fourNums = { -100, -100, -100, 0, 0, 0, 100, 100};
        int num = removeDuplicates(fourNums);
        System.out.println("output: " + Integer.toString(num));
    }
}
