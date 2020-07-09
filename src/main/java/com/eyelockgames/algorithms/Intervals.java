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


    public static void main(String[] args) {
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


