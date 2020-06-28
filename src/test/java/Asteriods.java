import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Asteriods {

    @Test
    public void shouldGetRemaining() {
        int[] asteroids =  {5, 10, -5};
        int[] expected =  {5, 10};
        int[] actual = asteroidCollision(asteroids);

        assertTrue(Arrays.equals(expected, actual));
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
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
