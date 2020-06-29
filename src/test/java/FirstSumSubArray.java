import com.eyelockgames.algorithms.slidingwindow.FindSubArray;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class FirstSumSubArray {

    // Find a set of numbers in an unsorted array that will add up to a given sum
    // return the index values of the begin and end of the numbers that add up to given sum
    @Test
    public void shouldFindSumSubArray() {
        int[] input = new int[] {1, 2, 3, 5, 7, 2};
        int[] expected = new int[] {3, 5};
        int[] actual = FindSubArray.findSumSubArray(input, 14);
        for(int i = 0; i < actual.length; i++) {
            System.out.println(actual[i]);
        }
        assertTrue(Arrays.equals(expected, actual));
    }

}
