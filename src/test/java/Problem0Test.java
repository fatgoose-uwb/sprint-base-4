/*
 * DO NOT MAKE ANY CHANGES UNLESS SPECIFIED OTHERWISE
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem0Test {

    // Okay to change the content of this function
    // DO NOT REMOVE OR CHANGE the signature
    @Test
    public void testSumOfNonUnique() {
        int[][] inputs = {
                {},
                {3},
                {3, 2},
                {2, 3},
                {2, 3, 2},
                {2, 4, 2, 1, 4, -5, 4},
                {0, 0, 0, 0},
                {5, 5, 5, 5},
                {-4, 2, -4, -4},
                {-7, -7, -7, -7},
                {2, 1, 2, 3, 2, 1, 2, 2, 3, 3, 1, 1, 5}
        };
        int[] expects = {
                0,
                0,
                0,
                0,
                4,
                16,
                0,
                20,
                -12,
                -28,
                23,
        };

        assertEquals(expects.length, inputs.length);

        for (int i = 0; i < inputs.length; i++) {
            int expect = expects[i];
            long actual = Problem0.SumOfNonUnique(inputs[i]);
            assertEquals("case " + i, expect, actual);
        }
    }

    @Test
    public void largeArrayTest() {
        final int aLargeNumber = 100000;
        int[] input = new int[aLargeNumber];

        for (int i = 0; i < input.length; i++) {
            input[i] = i - aLargeNumber / 2;    // does this array have any non-unique number in it?
        }

        final int expect = 0;   // why 0?

        long startTime = System.nanoTime();

        long actual = Problem0.SumOfNonUnique(input);

        long endTime = System.nanoTime();
        long durationInNano = endTime - startTime;

        assertEquals(expect, actual);

        System.out.printf("time: %f seconds", (double) durationInNano / 1e9);

        // TODO: show the running time with your code in homework 1, and the code here in this homework. How much
        //  improvement in running time are you able to achieve? Write a small paragraph explaining the reason for the
        //  improvement if any.
    }
}