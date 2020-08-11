package com.eyelockgames.codility;

import java.util.HashSet;
import java.util.Set;

public class Necklace {


    public static int longestNecklace(int[] K) {
        int max = 0;
        Set<Integer> necklaces = new HashSet<Integer>();
        for(int i = 0; i< K.length; i++) {
            if(K[i] != i) {
                if(!necklaces.contains(K[i])) {
                    int beads = 0;
                    int j = i;
                    while(!necklaces.contains(j)) {
                        beads++;
                        necklaces.add(j);
                        j = K[j];
                    }
                    max = Math.max(beads, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Given a jumble of necklcases find the longest necklace in the bunch..
        // [0] = 6
        // [1] = 1  Small necklace (1 bead)
        // [2] = 5
        // [3] = 2 Long necklace 4 (4 beads)
        // [4] = 3
        // [5] = 4
        // [6] = 0 Small necklace (2 beads...)
        int[] necklaces = new int[] {6, 1, 5, 2, 1, 4, 0};

        System.out.println("Longest necklace is: " + longestNecklace(necklaces));
    }
}
