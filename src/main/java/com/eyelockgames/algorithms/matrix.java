package com.eyelockgames.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class matrix {

/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4
 \ /   / | \
  3   5  8  9
   \ / \     \
    6   7    11

Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]

Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4],       // Individuals with zero parents
  [5, 7, 8, 9, 11] // Individuals with exactly one parent
]

n: number of pairs in the input

*/
    public static void main(String[] argv) {
        int[][] parentChildPairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };
        List<HashSet<Integer>> myList = findNodesWithZeroAndOneParents(parentChildPairs);
        HashSet<Integer> parents = myList.get(0);
        System.out.print("[ ");
        for(Integer i : parents) {
            System.out.print(i + " ");
        }
        System.out.println("]");
        System.out.print("[ ");
        HashSet<Integer> childs = myList.get(1);
        for(Integer i : childs) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public static List<HashSet<Integer>> findNodesWithZeroAndOneParents(int[][] pcp) {
        HashSet<Integer> up = new HashSet<Integer>();
        HashSet<Integer> uc = new HashSet<Integer>();
        HashSet<Integer> uc2 = new HashSet<Integer>();
        for(int i = 0; i< pcp.length; i++) {
            Integer j = new Integer(0);
            j = pcp[i][0];
            up.add(j);
            Integer child = new Integer(0);
            child = pcp[i][1];
            if(uc.contains(child)) {
                uc.remove(child);
            } else {
                uc.add(child);
            }
            uc2.add(child);
        }
        for(Integer i : uc2) {
            if(up.contains(i)) {
                up.remove(i);
            }
        }
        List<HashSet<Integer>> myList = new ArrayList<HashSet<Integer>>();
        myList.add(uc);
        myList.add(up);
        return myList;
    }
}
