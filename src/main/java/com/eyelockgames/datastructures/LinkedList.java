package com.eyelockgames.datastructures;

public class LinkedList {

    public static void main(String[] args) {
        Node a = new Node(12);
        Node b = new Node(4);
        a.next = b;
        Node c = new Node(2);
        b.next = c;
        Node d = new Node(1);
        c.next = d;
        Node e = a;
        while(true) {
            System.out.println(e.val);
            if(e.next == null) {
                break;
            }
            e = e.next;
        }
        Node f = Node.reverseLinkedList(a);
        while(true) {
            System.out.println(f.val);
            if(f.next == null) {
                break;
            }
            f = f.next;
        }
    }

    static class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
            next = null;
            prev = null;
        }

        public static Node reverseLinkedList(Node start) {
            Node returnList = new Node(start.val);
            while(start.next != null) {
                Node node = new Node(start.next.val);
                node.next = returnList;
                returnList = node;
                start = start.next;
            }
            Node node = new Node(start.val);
            node.next = returnList;
            returnList = node;

            return returnList;
        }

    }

}
