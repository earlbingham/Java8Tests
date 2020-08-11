package com.eyelockgames.algorithms;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        // For the given array
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");
        // Using streams, only select the elements that start with 'c',
        // make them uppercase and print them out.
        myList.stream()
                .filter(c -> c.startsWith("c"))
                .map(c -> c.toUpperCase())
                .forEach(System.out::println);
    }
}
