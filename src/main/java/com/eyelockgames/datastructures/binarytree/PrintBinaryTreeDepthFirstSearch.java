package com.eyelockgames.datastructures.binarytree;

public class PrintBinaryTreeDepthFirstSearch {

        public static void main(String[] args) {
//     Node n = new Node(3);
//     System.out.println(n);
//     Node n2 = new Node(4, n, new Node(5));
//     System.out.println(n2);

            Integer[] v = new Integer[]{1,2,3,4,5,6,7};
            System.out.println(Node.fromArray(v));
        }
    }

    class Node {
        Node left;
        Node right;
        int value;

        Node(int i) {
            value = i;
            left = null;
            right = null;
        }
        Node(int i, Node ln, Node rn) {
            left = ln;
            right = rn;
            value = i;
        }
        public static Node fromArray(Integer[] intArr) {
            return  buildSubtreeRec(intArr, 0, intArr.length-1);

        }

        public static Node buildSubtreeRec(Integer[] v, int lp, int rp) {
            // creates subtree from v[lp..rp]
            if(lp == rp) {
                return new Node(v[lp]);
            }

            int mid = (lp + rp) / 2;

            Node leftSubtree = buildSubtreeRec(v, lp, mid-1); // made from lp .. mid -1

            Node rightSubtree = buildSubtreeRec(v, mid+1, rp); // made from mid+1 .. rp

            return new Node( v[mid], leftSubtree, rightSubtree );
            // mid
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("(");
            if(left != null)  sb.append(left);
            sb.append(value);
            if(right != null)  sb.append(right);
            sb.append(")");
            return sb.toString();
        }
    }

/*
Node(3) => "(3)"
Node(4, Node(3), Node(5)) => "((3)4(5))"

Integer[] v = new Integer[]{1,2,3,4,5,6,7};

Node.fromArray([1,2,3,4,5,6,7])
addNodeRec(v, 0, 6)
...
addNodeRec(v, 0, 2) => new Node(2, addNodeRec(v, 0, 0), addNodeRec(v, 2, 2))

addNodeRec(v, 0, 0) => new Node(1, addNodeRec(v, -1, 0))
  addNodeRec(v, -1, 0)) => null

=>
new Node(4,
     new Node(2, new Node(1), new Node(3))
     new Node(6, new Node(5), new Node(7))

*/