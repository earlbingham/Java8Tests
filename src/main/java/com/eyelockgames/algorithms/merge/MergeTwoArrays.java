package com.eyelockgames.algorithms.merge;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3, 5, 7, 9};
        int[] arr2 = new int[] {1, 2, 4, 6};

        int[] arr3 = mergeTwo(arr1, arr2);
        for(int i = 0; i<arr3.length; i++) {
System.out.println(arr3[i]);
        }
    }

    private static int[] mergeTwo(int[] arr1, int[] arr2) {
        int i = 0; int k = 0;
        List<Integer> ret = new ArrayList<>();

        while(i < arr1.length && k < arr2.length) {
            if(arr1[i] < arr2[k]) {
                ret.add(arr1[i++]);
            } else if(arr1[i] > arr2[k]) {
                ret.add(arr2[k++]);
            } else {
                ret.add(arr1[i++]);
                ret.add(arr2[k++]);
            }
        }
        int[] itemsArray = ret.stream().mapToInt(j->j).toArray();

        return itemsArray;
    }

}
