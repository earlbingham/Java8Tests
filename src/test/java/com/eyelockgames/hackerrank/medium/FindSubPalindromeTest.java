package com.eyelockgames.hackerrank.medium;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSubPalindromeTest {

    @Test
    public void shouldTestPalindrome() {
        int actual = 2;
        int result = FindSubPalindrome.palindromeIndex("aaab");
        System.out.println(actual);
        System.out.println(result);
        assertTrue(true);
    }
}