package com.eyelockgames.algorithms.slidingwindow;

public class FindSubArray {

    public static String findSmallestString(String input) {
        return "";
    }

    /*
        Given an array of numbers, find the first set of numbers that
        add up to the given sum.
         */
    public static int[] findSumSubArray(int[] input, int sum) {
        int last = 0;
        int[] returnArr = new int[] {0, 0};
        int current = 0;
        int matchSum = 0;
        while (current < input.length) {
            matchSum = matchSum + input[current];
            if((matchSum - sum) > 0) {
                while((matchSum - sum) > 0) {
                    matchSum = matchSum - input[last];
                    last++;
                }
            }
            if(matchSum == sum) {
                returnArr[0] = last;
                returnArr[1] = current;
                return returnArr;
            }
            current++;
        }
        if(matchSum == sum){
            returnArr[0] = last;
            returnArr[1] = current-1;
            return returnArr;
        }
        return returnArr;
    }

}
