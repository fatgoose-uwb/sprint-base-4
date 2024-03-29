package Problem2Test;

/*
 * DO NOT MAKE ANY CHANGES
 */

import Problem2.BinarySearch;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    @Test(expected = InvalidParameterException.class)
    public void testBinarySearchInvalidInputs() {
        BinarySearch.binarySearch(null, -1);
    }

    @Test
    public void testBinarySearchValidInputs() {
        int[][] inputs = {
                {},
                {3},
                {3},
                {1, 3},
                {1, 3},
                {4, 6, 8},
                {4, 6, 8},
                {4, 6, 8},
                {3, 5, 7, 9, 20},
                {3, 5, 7, 9, 20},
        };
        int[] targets = {9, 1, 3, 1, 3, 4, 6, 8, 3, 9};
        int[] answer = {-1, -1, 0, 0, 1, 0, 1, 2, 0, 3};

        assertEquals(inputs.length, targets.length);
        assertEquals(inputs.length, answer.length);

        for (int i = 0; i < inputs.length; i++) {
            int actual = BinarySearch.binarySearch(inputs[i], targets[i]);
            int expected = answer[i];
            assertEquals(expected, actual);
        }
    }
}