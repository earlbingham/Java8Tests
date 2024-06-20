package com.eyelockgames.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MinDaysForBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        if ( (m * k) > bloomDay.length) {
            return -1;
        }
        int[] usedFlowersArray = Arrays.copyOf(bloomDay, bloomDay.length);
        int currentDay = 0;
        int bouquetsMade = 0;
        while (bouquetsMade < m) {
            currentDay++;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= currentDay && usedFlowersArray[i] != 0) {
                    boolean foundABouquet = true;
                    int foundFlowers = 1;
                    if (i + 1 >= bloomDay.length) {
                        break;
                    }
                    for (int j = 1; j < bloomDay.length; j++) {
                        if ((i + j) >= usedFlowersArray.length || usedFlowersArray[i + j] == 0) {
                            continue;
                        }
                        if (((i + j) >= bloomDay.length) || bloomDay[i + j] > currentDay) {
                            foundABouquet = false;
                            break;
                        }
                        foundFlowers++;
                        if (foundFlowers >= k) {
                            break;
                        }
                    }
                    foundFlowers = 0;
                    if (foundABouquet) {
                        for (int j = 0; (i + j) < bloomDay.length; j++) {
                            if (((i + j) >= bloomDay.length) || usedFlowersArray[i + j] == 0) {
                                continue;
                            }
                            if (((i + j) <= bloomDay.length) && bloomDay[i + j] <= currentDay) {
                                usedFlowersArray[i + j] = 0;
                            }
                            foundFlowers++;
                            if (foundFlowers >= k) {
                                break;
                            }
                        }
                        if (foundFlowers >= k) {
                            bouquetsMade++;
                        }
                    }
                }
            }
        }
        return currentDay;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 5,37,55,92,22,52,31,62,99,64,92,53,34,84,93,50,28 };
        int num = minDays(bloomDay, 8, 2);
        System.out.println("results: " + num);
//        num = minDays(bloomDay, 3, 2);
//        System.out.println("results: " + num);
//        int[] bloomDayTwo = { 7,7,7,7,12,7,7 };
//        num = minDays(bloomDayTwo, 2, 3);
//        System.out.println("results: " + num);
    }
}
