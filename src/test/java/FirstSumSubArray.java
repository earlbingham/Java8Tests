import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstSumSubArray {

    // Find a set of numbers in an unsorted array that will add up to a given sum
    // return the index values of the begin and end of the numbers that add up to given sum
    @Test
    public void shouldFindSumSubArray() {
        int[] input = new int[] {1, 2, 3, 5, 7, 2};
        int[] expected = new int[] {3, 5};
        int[] actual = findSumSubArray(input, 14);
        for(int i = 0; i < actual.length; i++) {
            System.out.println(actual[i]);
        }
        assertTrue(Arrays.equals(expected, actual));
    }

    public int[] findSumSubArray(int[] input, int sum) {
        int last = 0;
        int[] returnArr = new int[] {0, 0};
        int current = 0;
        int matchSum = 0;
        while (current < input.length) {
            matchSum = matchSum + input[current];
            if((matchSum - sum) > 0) {
                while((matchSum - sum) > 0) {
                    matchSum = matchSum - input[last];
                    last++;
                }
            }
            if(matchSum == sum) {
                returnArr[0] = last;
                returnArr[1] = current;
                return returnArr;
            }
            current++;
        }
        if(matchSum == sum){
            returnArr[0] = last;
            returnArr[1] = current-1;
            return returnArr;
        }
        return returnArr;
    }
}
