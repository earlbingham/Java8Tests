package com.eyelockgames.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindSubPalindrome {

    private static final Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) throws IOException {
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int qItr = 0; qItr < q; qItr++) {
//            String s = scanner.nextLine();
//
//            int result = palindromeIndex(s);
//            System.out.println(result);
////            bufferedWriter.write(String.valueOf(result));
////            bufferedWriter.newLine();
//        }
//
////        bufferedWriter.close();
//
//        scanner.close();
//    }

    public static void main(String[] args) {
        int result = FindSubPalindrome.palindromeIndex("aaab");
        System.out.println(result);
    }
    static int palindromeIndex(String s) {
        if(isPalindrome(s) || s.length() < 2) return -1;
        for(int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i - 1) +
                    s.substring(i, s.length())))
                return i-1;
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
