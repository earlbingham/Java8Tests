package com.eyelockgames.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSubArray {

/*
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

  https://leetcode.com/problems/maximum-subarray/
 */

    // brute force is O(n)
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
            sum = 0;
        }
        return maxSum;
    }

    static int anagram(String s) {
        if(s.length() % 2 != 0) return -1;

        char[] a = s.substring(0, s.length()/2).toCharArray();
        List<Character> e = s.substring(0, s.length()/2)
                .chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> f = s.substring(s.length()/2)
                .chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> i1 = new ArrayList<Character>(f);
        i1.retainAll(e);
        List<Character> i2 = new ArrayList<Character>(f);
        i2.retainAll(e);

        return s.length()/2 - (Math.min(i1.size(), i2.size()));
//        char[] b = s.substring(s.length()/2, s.length()).toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);
//        int i = 0; int j = 0;
//        int changes = 0;
//        while(i < a.length && j < b.length) {
//
//            while(a[i] < b[j] && i < a.length) {
//                changes++;
//                i++;
//            }
//            while(b[j] < a[i] && j < b.length) {
//                changes++;
//                j++;
//            }
//            if(a[i] == b[j]) { i++; j++; }
//        }
//        return changes;
    }
//   public static int maxSubArrayEric2(int[] nums) {
//     int sum = Integer.MIN_VALUE;
//     int maxSum = Integer.MIN_VALUE;
//     for(int i = 0; i<nums.length; i++) {
//       sum = sum + nums[i];
//       if(sum > maxSum) {
//         first = i;
//         maxSum = sum
//         ;
//       } else {
//         // do nothing
//       }
//     }

//     return maxSum;
//   }

    public static int maxSub(String s) {
        int len = s.length(), count = 0;
        if (len%2!=0) return -1;

        String s1 = s.substring(0,len/2);
        StringBuilder s2 = new StringBuilder(s.substring(len/2,len));
        char[] s1Chars = s1.toCharArray();
        for (char c : s1Chars){
            int index = s2.indexOf(Character.toString(c)); // .indexOf(c);
            if (index == -1) {
                count++;
            } else {
                s2.deleteCharAt(index);
            }
        }
        return count;
    }

    public static long solution (long[] prices) {
        if(prices.length == 0) return 0;
        long max = 0;
        long lowest = Long.MAX_VALUE;
        for(int i = 1; i < prices.length; i++ ) {
            if(prices[i] <= lowest) {
                lowest = prices[i];
            }
            if(prices[i] - lowest > max) {
                max = prices[i] - lowest;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //int i = anagram("aaabbb");
         //int i = anagram("xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa");
         // int i = anagram("fdhlvosfpafhalll");
//         int i = maxSub("fdhlvosfpafhalll");
//         long[] prices = new long[] {13, 10, 8, 4, 10};

//        System.out.println(solution(prices));
        System.out.println("roundUp: 3: " + roundUp(3));
        System.out.println("roundUp: 4: " + roundUp(4));
        // int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] input = new int[]{-2,1};
//        int result = maxSubArray(input);
//        System.out.println("result = " + result);
    }

    public static int roundUp(int num) {
        return (int) Math.ceil((double)num / 2);

    }
}

