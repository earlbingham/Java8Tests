import com.eyelockgames.datastructures.StackDS;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Asteriods {

    // This ones tied to youtube video: https://www.youtube.com/watch?v=5AV33YdtDYw&t=623s
    // I'm starting to like him the most regarding coding tutorials
    @Test
    public void shouldGetRemaining() {
        int[] asteroids =  {5, 10, -5};
        int[] expected =  {5, 10};
        int[] actual = StackDS.asteroidCollision(asteroids);

        assertTrue(Arrays.equals(expected, actual));
    }


}
