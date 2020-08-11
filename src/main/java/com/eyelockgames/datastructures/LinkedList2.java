package com.eyelockgames.datastructures;

public class LinkedList2 {

    static class Node {
        int val;
        Node next;

    }

    public static void main(String[] args) {
        Node a = new Node();
        a.val = 3;
        Node b = new Node();
        b.val = 5;
        a.next = b;
        Node c = new Node();
        c.val = 7;
        b.next = c;

        printList(a);
        a = reverseList(a);
        printList(a);
    }

    private static Node reverseList(Node a) {
        Node prev = null;
        Node current = a;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        a = prev;
        return a;
    }

    private static void printList(Node z) {
        Node a = z;
        while (true) {
            if(a != null) {
                System.out.print(" " + a.val);
            }
            if(a.next != null) {
                a = a.next;
            } else {
                break;
            }
        }
        System.out.println(".");
    }
}
