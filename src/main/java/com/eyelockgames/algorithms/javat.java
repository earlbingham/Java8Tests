package com.eyelockgames.algorithms;

import java.util.*;
public class javat {

    /**
     a=[9,3,5,7,6];
     b=[8,12,3,5,13]
     output=[3,5]
     -------
     a=[2,3,4,5]
     o=[60,40,30,24]
     treemap (2, 60) (3, 40) (4, 30), (5, 24)
     */

//        public static List<Integer> makeProductList(List<Integer> sortA) {
//            List<Integer> prodL = new ArrayList<Integer>();
//
//            int[] arr  = sortA.keySet().toArray()[0];
//            for(int j = 0; j < sortA.size(); j++ ) {
//                for(int k = 0; k < sortA.size(); k++ ) {
//                    if(k != j) {
//                        int cur = tm.get(arr[j]);
//                        tm.remove(arr[j]);
//                        tm.put(arr[j], cur * tm.get(arr[k]));
//                    }
//                }
//            }
//            tm.values
//        }

        public static List<Integer> findMatchesSorted(List<Integer> sortA,
                                                      List<Integer> sortB) {
            int i = 0; int j = 0;
            List<Integer> ret = new ArrayList<Integer>();
            while (i < sortA.size() && j < sortB.size()) {
                if(sortA.get(i) == sortB.get(j)) {
                    ret.add(sortA.get(i));
                    i++; j++;
                } else if(sortA.get(i) < sortB.get(j)) {
                    i++;
                } else if(sortA.get(i) > sortB.get(j)) {
                    j++;
                }
            }
            return ret;
        }

        public static List<Integer> sortArray2(List<Integer> unsortA, List<Integer> unsortB) {
            Set<Integer> fin = new HashSet<Integer>(unsortB);
            List<Integer> ret = new ArrayList<Integer>();
            for(Integer i : unsortA) {
                if(i != null && fin.contains(i)) {
                    ret.add(i);
                }
            }
            Collections.sort(ret);
            return ret;
        }

        public static void main2(String[] args) {
            //int[] a = new int[]{9,3,5, 7, 6 };
            //int[] a = null;
            int[] a = new int[]{1,2,3,4,5,6,7,8,9 };
            // int[] b = new int[]{8,12, 3,5,13};
            int[] b = new int[]{1, 5, 10, 11};
            List<Integer> ar1 = new ArrayList<Integer>(a == null ? 0 : a.length);
            if(a != null)
                for(int i : a) ar1.add(i);
            List<Integer> ar2 = new ArrayList<Integer>(b == null ? 0 : b.length);
            if(b != null)
                for(int i : b) ar2.add(i);
            findMatchesSorted(ar1, ar2).stream().forEach(System.out::println);
        }

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

    /**
     a=[9,3,5,7,6];
     b=[8,12,3,5,13]
     output=[3,5]
     */

        public static List<Integer> sortArray(List<Integer> unsortA, List<Integer> unsortB) {
            Set<Integer> fin = new HashSet<Integer>(unsortB);
            List<Integer> ret = new ArrayList<Integer>();
            for(Integer i : unsortA) {
                if(fin.contains(i)) {
                    ret.add(i);
                }
            }
            Collections.sort(ret);
            return ret;
        }

        public static void main(String[] args) {
            int[] a = new int[]{9,3,5,7, 6 };
            int[] b = new int[]{8,12,3,5,13};
            List<Integer> ar1 = new ArrayList<Integer>(a.length);
            for(int i : a) ar1.add(i);
            List<Integer> ar2 = new ArrayList<Integer>(b.length);
            for(int i : b) ar2.add(i);
            sortArray(ar1, ar2).stream().forEach(System.out::println);
        }
    }
