package com.eyelockgames.algorithms;

import java.util.*;

public class Intervals {

/*
Given a string you need to check if it is possible to make a palindrome after removing exactly one character from the string
goolg- true
hierkih - false
*/

/*
Given a list of intervals, merge all overlapping intervals.
Input: [[1,5],[2,7],[8,13],[15,18]]
Output: [[1,7],[8,13],[15,18]]
*/

    static class Node {
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Node> mergeNodes(List<Node> l) {
        List<Node> r = new ArrayList<Node>();
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (Node y : l) {
            m.put(y.start, y.end);
        }
        for (Integer i : m.keySet()) {
            for (Node z : l) {
                if (z.start > i && z.end < m.get(i)) {
                    r.add(new Node(z.start, m.get(i)));
                    // m.remove(i);
                    l.remove(z);
                    break;
                } else if ((z.start < i) && (z.end < m.get(i))) {
                    r.add(new Node(z.start, m.get(i)));
                    // m.remove(i);
                    l.remove(z);
                    break;
                }
            }
        }
        for (Node z : l) {
            r.add(z);
        }
        // for (Map.Entry<Integer, Integer> p : m.entrySet()) {
        //   Node a = new Node(p.getKey(), p.getValue());
        //   r.add(a);
        // }
        return r;
    }

    // Write a Java program to find the common elements between two arrays of integers.
    // Array1 : [1, 2, 5, 5, 8, 9, 7, 10]
    // Array2 : [1, 0, 6, 15, 6, 4, 7, 0]
    // Common element is : 1
    // Common element is : 7
    public void findCommonElement(List<Integer> a1, List<Integer> a2) {
        Set<Integer> a1Set = new HashSet<Integer>();
        for(Integer i : a1) {
            a1Set.add(i);
        }
        for(Integer j : a2) {
            if(a1Set.contains(j)) {
                System.out.println("Common element is : " + j);
            }
        }
    }

    public void findCommonElement2(List<Integer> a1, List<Integer> a2) {
        Collections.sort(a1);
        Collections.sort(a2);
        int i = 0; int j = 0;
        while (i < a1.size() || j < a2.size()) {
            if(a1.get(i) == a2.get(j)) {
                System.out.println("Common element is : " + a1.get(i));
                if(i+1 == a1.size()) {
                    break;
                }
                if(j+1 == a2.size()) {
                    break;
                }
            } else if(a1.get(i) > a2.get(j)) {
                if(j+1 == a2.size()) {
                    break;
                } else {
                    j++;
                }
            } else if(a1.get(i) < a2.get(j)) {
                if(i+1 == a1.size()) {
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    // Convert Character String to Integer without using any inbuilt function
    //    I/P1 = "12345", O/P1 = 12345 (int)
    //    I/P2 = "12S45", O/P2 = 1245 (int)
    //    I/P3 = "12 45", O/P3 = 1245 (int)
    //    I/P4 = "ABCDS", O/P3 = -1 (int)
    public Integer convertStringToInteger(String inputString) {
        Integer returnInteger = 0;
        boolean isNegative = false;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.substring(i, i + 1).matches("^/[0-9 -]$")) {
                if (inputString.charAt(i) == '-') {
                    isNegative = true;
                    if (inputString.charAt(i) == ' ') {
                        continue;
                    }
                    int currentNumber = inputString.charAt(i) - '0';
                    if (returnInteger > 0) {
                        returnInteger = returnInteger * 10;
                    }
                    returnInteger = returnInteger + currentNumber;
                } else {
                    return new Integer(-1);
                }
            }
        }
        if (isNegative) {
            returnInteger = returnInteger - (2 * returnInteger);
        }
        return returnInteger;
    }

    // Given nums = [2, 7, 11, 15], target = 9.
    // The output should be [0, 1].
    // Because nums[0] + nums[1] = 2 + 7 = 9.

    public int[] findTwoSum(int[] nums, int target) {
        int[] rArr = new int[2];
        int last = 0; int j = 0; int sum = 0;
        for(int k = 0; k < nums.length; k++) {
            if(nums[k] < target) {
                if(nums[k] + sum == target) {
                    rArr[0] = last;
                    rArr[1] = k;
                    return rArr;
                } if(nums[k] + sum < target) {
                    sum = sum - nums[last];
                    last++;
                }
            }
        }
        return rArr;
    }

    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<Integer>();

        Node a = new Node(1, 5);
        Node b = new Node(2, 7);
        List<Node> l = new ArrayList<Node>();
        l.add(a);
        l.add(b);
        List<Node> r = mergeNodes(l);
        for (Node z : r) {
            System.out.println("start: " + z.start + " end: " + z.end);
        }

        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        MergeOverlappingIntervals.mergeIntervals(arr);
    }


    // An Interval
    static class Interval
    {
        int start,end;

        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
    }

    static public class MergeOverlappingIntervals {

        // Function that takes a set of intervals, merges
        // overlapping intervals and prints the result
        public static void mergeIntervals(Interval arr[])
        {
            // Sort Intervals in decreasing order of
            // start time
            Arrays.sort(arr,new Comparator<Interval>(){
                public int compare(Interval i1,Interval i2)
                {
                    return i2.start - i1.start;
                }
            });

            int index = 0; // Stores index of last element
            // in output array (modified arr[])

            // Traverse all input Intervals
            for (int i=1; i<arr.length; i++)
            {
                // If this is not first Interval and overlaps
                // with the previous one
                if (arr[index].end >=  arr[i].start)
                {
                    // Merge previous and current Intervals
                    arr[index].end = Math.max(arr[index].end, arr[i].end);
                    arr[index].start = Math.min(arr[index].start, arr[i].start);
                }
                else {
                    arr[index] = arr[i];
                    index++;
                }
            }

            // Now arr[0..index-1] stores the merged Intervals
            System.out.print("The Merged Intervals are: ");
            for (int i = 0; i <= index; i++)
            {
                System.out.print("[" + arr[i].start + ","
                        + arr[i].end + "]");
            }
        }
    }
}

/*

Given a string you need to check if it is possible to make a palindrome after removing exactly one character from the string
goolg- true
hierkih - false
 */
