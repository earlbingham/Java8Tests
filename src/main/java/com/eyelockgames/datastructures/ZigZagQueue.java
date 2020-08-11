package com.eyelockgames.datastructures;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 *               5
                / \
               2   7
              / \ / \
             1  3 6  8
 *    5, 2, 7, 3, 1, 6, 8
 root, left, right ; right left

 BFS but with alternating RL, LR
 int direction = 0;
 if( direction % 2 == 0) { RL } else  { LR }
 direction++
 */



class ZigZagQueue {

//    public static void zigZag(Node root) {
//
//        if(root == null) return;
//
//        LinkedList<Node> q = new LinkedList<>();
//
//        q.push(root);
//        int direction = 0;
//        while(!q.isEmpty()){
//
//            Node n = q.poll();
//
//            System.out.println(n.data);
//
//            if(direction % 2 == 0) {
//                addChildren(q, n.leftChild, n.rightChild);
//            } else {
//                addChildren(q, n.rightChild, n.leftChild );
//            }
//
//            direction++;
//        }
//
//    }

//    static void addChildren(LinkedList<Node> q, Node n1, Node n2) {
//
////        if( n1 != null) {
////            q.add(n1); // push would act as a stack...
////        }
////
////        if( n2 != null) {
////            q.add(n2); // push would act as a stack...
////        }
//    }

    public static class Node  {
        int data;
        Node leftChild;
        Node rightChild;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.leftChild = new Node(2);
        tree.rightChild = new Node(7);
        tree.leftChild.leftChild = new Node(1);
        tree.leftChild.rightChild = new Node(3);
        tree.rightChild.leftChild = new Node(6);
        tree.rightChild.rightChild = new Node(8);

        System.out.println("ZigZag Order traversal of binary tree is");
        //zigZag(tree);

    }
}

