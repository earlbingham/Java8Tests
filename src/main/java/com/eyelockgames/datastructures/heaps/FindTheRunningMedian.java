package com.eyelockgames.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Properties;

public class FindTheRunningMedian {

    static double[] runningMedian(int[] a) {
        double[] retArr = new double[a.length];
        if(a.length == 0) return retArr;
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>();
        return retArr;
    }

    public static void main(String[] args) {
        String a = "attract";
        System.out.println(removePalindromeSub(a));

    }
    public static int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 :
                (s.equals(new StringBuilder(s).reverse().toString()) ? 1:2);
    }

    private static int minDiff(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer i : arr) {
            pq.add(i);
        }
        int sum = 0;
        int curr = pq.poll();
        int k = pq.size();
        for(int i = 0; i< k; i++) {
            int j = pq.poll();
            sum += Math.abs(curr - j);
            curr = j;
        }
        return sum;
    }

    private static int minSum(List<Integer> num, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer i : num) {
            pq.add(-i);
        }
        for(int i = 0; i < k; i++) {
            Integer j = -pq.poll();
            j = (int) Math.ceil( (double) j / 2);
            pq.add(-j);
        }
        int j = pq.size();
        int sum = 0;
        for(int i = 0 ; i < j; i++) {
            sum += -pq.poll();
        }
        return sum;
    }

    public static String findLongestPalindrome(String str) {
        // starting point for comparison with other palindromes
        String longestPalindrome = str.substring(0, 1);
        for (int i = 0; i < str.length(); i = i+1) {
            // odd length case (center is i)
            String newPalindrome = checkIfEqual(str, i, i);
            if (newPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = newPalindrome;
            }
            // even length case (center is i, i+1)
            newPalindrome = checkIfEqual(str, i, i + 1);
            if (newPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = newPalindrome;
            }
        }
        return longestPalindrome;
    }

    public static String checkIfEqual(String str, int begin, int end) {
        while ((begin >= 0 && end <= str.length() - 1) && (str.charAt(begin) == str.charAt(end))) {
            begin--;
            end++;
        }
        return str.substring(begin + 1, end);
    }

}

