package com.eyelockgames.hackerrank.medium;

import com.eyelockgames.algorithms.caterpillar.FindSmallestString;

public class BearAndSteadyGene {

    public static void main(String[] args) {
        String input = "GAAATAAA";
        int expected = 5;
        System.out.println("expected: "+ expected);
        System.out.println("smallest: "+ FindSmallestString.findSmallestString(input));
    }

}
