package com.eyelockgames.hackerrank.medium;

public class FindSubPalindrome {

    static int palindromeIndex(String s) {
        if(isPalindrome(s) || s.length() < 2) return -1;
        for(int i = 2; i< s.length(); i++) {
            if(isPalindrome(s.substring(0, i))) {
                return i;
            }
            if(isPalindrome(s.substring(s.length()-i, s.length()-1))) {
                return s.length()-i;
            }
        }
        return -1;
    }

    public static boolean isPalindrome(String s) {
        if(s.length() < 2) return false;
        String b = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            b = b + s.charAt(i);
        }
        return s.equalsIgnoreCase(b);
    }

}
