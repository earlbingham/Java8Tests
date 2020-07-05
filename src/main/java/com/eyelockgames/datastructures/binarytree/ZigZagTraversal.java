package com.eyelockgames.datastructures.binarytree;

import java.util.*;

// This Code is contributed by Harikrishnan Rajan.
public class ZigZagTraversal {

    // Binary Tree node
    public static class Node  {
        int data;
        Node leftChild;
        Node rightChild;
        Node(int data) {
            this.data = data;
        }
    }

    public Node rootNode;

    // function to print the
    // zigzag traversal
    void printZigZagTraversal() {
        // if null then return
        if (rootNode == null) {
            return;
        }

        // declare two stacks
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            Node node = currentLevel.pop();

            // print the data in it
            System.out.print(node.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.leftChild != null) {
                    nextLevel.push(node.leftChild);
                }
                if (node.rightChild != null) {
                    nextLevel.push(node.rightChild);
                }
            } else {
                if (node.rightChild != null) {
                    nextLevel.push(node.rightChild);
                }
                if (node.leftChild != null) {
                    nextLevel.push(node.leftChild);
                }
            }
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
    // driver program to test the above function
    public static void main(String[] args) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.rootNode = new ZigZagTraversal.Node(1);
        tree.rootNode.leftChild = new ZigZagTraversal.Node(2);
        tree.rootNode.rightChild = new ZigZagTraversal.Node(3);
        tree.rootNode.leftChild.leftChild = new ZigZagTraversal.Node(7);
        tree.rootNode.leftChild.rightChild = new ZigZagTraversal.Node(6);
        tree.rootNode.rightChild.leftChild = new ZigZagTraversal.Node(5);
        tree.rootNode.rightChild.rightChild = new ZigZagTraversal.Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}
