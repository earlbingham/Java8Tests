package com.eyelockgames.datastructures.heaps;

import java.util.PriorityQueue;

public class FindTheRunningMedian {

    static double[] runningMedian(int[] a) {
        double[] retArr = new double[a.length];
        if(a.length == 0) return retArr;
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>();
        return retArr;
    }

    public static void main(String[] args) {
        int[] a = new int[] {12 , 4 , 5 , 3 , 8 , 7};

    }
}

