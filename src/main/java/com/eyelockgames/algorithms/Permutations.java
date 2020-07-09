package com.eyelockgames.algorithms;

public class Permutations {

// 123
// 123, 132, 213, 231, 312, 321

        public static void main(String[] args) {
            print("123");
        }
        public static void print(String input) {
            if(input.length() < 2) printOutChArr(input.toCharArray());
            char[] chArr = input.toCharArray();
            printChArr(chArr.length, chArr);
        }

        public static void printChArr(int n, char[] chArr) {
            if(n == 1) {
                printOutChArr(chArr);
            } else {
                for(int i = 0 ; i < n-1; i++) {
                    printChArr(n - 1, chArr);
                    if(i % 2 == 0) {
                        swap(chArr, i, n-1);
                    } else {
                        swap(chArr, 0, n-1);
                    }
                }
                printChArr(n - 1, chArr);
                // printOutChArr(chArr);
            }
        }

        public static void swap(char[] chArr, int a, int b) {
            char t = chArr[a];
            chArr[a] = chArr[b];
            chArr[b] = t;
        }

        public static void printOutChArr(char[] chArr) {
            for(int i = 0; i < chArr.length; i++) {
                System.out.print(chArr[i]);
            }
            System.out.println(" ");
        }
    }


