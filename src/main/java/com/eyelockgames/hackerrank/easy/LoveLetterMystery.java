package com.eyelockgames.hackerrank.easy;

public class LoveLetterMystery {
    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int delta = 0;
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                delta += Math.abs(s.charAt(i) - s.charAt(j));
            }
            i++; j--;
        }
        return delta;
    }

    public static void main(String[] args) {
        String s = "abcd";
        int num = theLoveLetterMystery(s);
        System.out.println(s + num);
    }
}
