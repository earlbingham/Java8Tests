package com.eyelockgames.datastructures;

public class StackDS {

    public static int[] asteroidCollision(int[] asteroids) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        int i = 0;
        while(i < asteroids.length) {
            if(asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0 ) {
                    stack.push(asteroids[i]);
                } else if(stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
            }
            i++;
        }
        int[] remaining = new int[stack.size()];
        for(int j = stack.size()-1; j >= 0; j-- ) {
            remaining[j] = stack.pop();
        }
        return remaining;
    }

}
