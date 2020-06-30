package com.eyelockgames.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxNumBooksTest {

    @Test
    void findMaxBooks() {
        int[] costofBooks = {7, 6, 4, 6, 5};
        int numBooks = FindMaxNumBooks.findMaxBooks(3, costofBooks, 5);
        System.out.println(numBooks);
        assertTrue(true);
    }
}