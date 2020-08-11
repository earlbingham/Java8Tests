package com.eyelockgames.hackerrank;

import java.util.TreeSet;

public class MinMax {

    public static void main(String[] args) {
        int[] a = new int[] {10 , 100 , 300 , 200 , 1000 , 20, 30};
        System.out.println(maxMin(3, a));
    }
    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        int[] unf = sort(k, arr);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<unf.length; i++) {
            min = Math.min(min, unf[i]);
            max = Math.max(max, unf[i]);
        }
        return max - min;
    }

    public static int[] sort(int k, int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        int mid = arr.length/2;
        int left = mid - (k/2);
        int right = mid + (k/2);
        int[] result = new int[right-left];

        for(int i = 0; i < result.length; i++) {
            result[i] = arr[left];
            left++;
        }
        return result;
    }
}

