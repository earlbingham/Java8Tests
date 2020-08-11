package com.eyelockgames.datastructures.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * The basic approach of the Breadth-First Search (BFS) algorithm is to
 * search for a node into a tree or graph structure by exploring
 * neighbors before children.
 * the BFS algorithm uses a queue to traverse the nodes
 *
 * The depth-first search goes deep in each branch before moving
 * to explore another branch.
 *
 */
class LevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> nodes = new Stack<>();
        if(root != null)
            nodes.push(new ArrayList<>(root.val));

        List<List<Integer>> returnList = new ArrayList<>();

        return returnList;
    }

    public static List<List<Integer>> traversePreOrderWithoutRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);

        while(!rootList.isEmpty()) {
            List<Integer> resultList = new ArrayList<>();
            List<TreeNode> listToTraverse = new ArrayList<>();

            for(TreeNode tn : rootList) {
                resultList.add(tn.val);
                if (tn.right != null) {
                    listToTraverse.add(tn.right);
                }
                if (tn.left != null) {
                    listToTraverse.add(tn.left);
                }
            }
            result.add(0, resultList);
            rootList = listToTraverse;
        }
        return result;
    }

    public List<Integer> traversePreOrder(TreeNode node) {
        List<Integer> returnList = new ArrayList<>();
        if (node != null) {
            returnList.addAll(traversePreOrder(node.left));
            returnList.addAll(traversePreOrder(node.right));
            returnList.add(node.val);
        }
        return returnList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(3);
        tn.right = new TreeNode(9);
        tn.left = new TreeNode(20);
        tn.right.right = new TreeNode(7);
        tn.right.left = new TreeNode(15);
        List<List<Integer>> listList =
                traversePreOrderWithoutRecursion(tn);
        Iterator<List<Integer>> iterator = listList.iterator();
        if(iterator.hasNext())
            System.out.println('[');
        while (iterator.hasNext()) {
            boolean first = true;
            Iterator<Integer> iter = iterator.next().iterator();
            while(iter.hasNext()) {
                int i = iter.next();
                if(first) {
                    System.out.print('[');
                    first = false;
                }
                System.out.print(i);
                if(iter.hasNext())
                    System.out.print(',');
                else {
                    if(iterator.hasNext()) {
                        System.out.println("],");
                    } else {
                        System.out.println(']');
                    }
                }
            }
        }
        if(listList.size() > 0) {
            System.out.println(']');
        }
    }
}