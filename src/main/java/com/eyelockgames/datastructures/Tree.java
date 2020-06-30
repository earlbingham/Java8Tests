//package com.eyelockgames.datastructures;
//
//public class import java.io.*;
//        import java.util.*;
//
///*
//
// Given a tree
//          1
//      2          3
//   4    5     6     7
// 8  9 10 11 12 13 14 15
//
// Print 1,3,2,4,5,6,7, 15,14,13...8
// Make sure code is testable
//
// */
//
//class BTree {
//    BTree r;
//    BTree l;
//    int val;
//
//    BTree(BTree r, Btree l, int val) {
//        this.r = r;
//        this.l = l;
//        this.val = val;
//    }
//
//    traverse(Btree p) {
//
//    }
//    public List<Character>  traverse(Btree b) {
//        Btree cP = b;
//        Btree prevP;
//        boolean dir = true;
//        boolean isFirst = true;
//        while(true) {
//            if(isFirst) {
//                System.out.println(cP.val);
//                isFirst = false;
//                prevP = cP;
//            }
//            if(dir) {
//                if(cP.r != null) {
//                    System.out.println(cP.r.val);
//                }
//                if(cP.l != null) {
//                    System.out.println(cP.l.val);
//                    cP = l;
//                }
//                dir = false;
//            } else {
//                if(cP.l != null) System.out.println(cP.l.val);
//                if(cP.r != null) {
//                    System.out.println(cP.r.val);
//                    cp = r;
//                }
//                dir = true;
//            }
//        }
//    }
//
//    class Solution {
//        public static void main(String[] args) {
//            ArrayList<String> strings = new ArrayList<String>();
//            strings.add("Hello, World!");
//            strings.add("Welcome to CoderPad.");
//            strings.add("This pad is running Java " + Runtime.version().feature());
//
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        }
//    }
//    Tree {
//}
