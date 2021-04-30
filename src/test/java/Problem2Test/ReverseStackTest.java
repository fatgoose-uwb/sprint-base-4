package Problem2Test;

/*
 * DO NOT MAKE ANY CHANGES
 */

import Problem2.ReverseStack;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

public class ReverseStackTest {
    @Test
    public void reverseStack() {
        int[][] inputs = {
                {},
                {3},
                {1, 3},
                {4, 6, 8},
                {3, 5, 7, 9, 20},
        };
        int[][] expects = {
                {},
                {3},
                {3, 1},
                {8, 6, 4},
                {20, 9, 7, 5, 3},
        };
        for (int i = 0; i < inputs.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < inputs[i].length; j++) {
                stack.push(inputs[i][j]);
            }
            ReverseStack.reverseStack(stack);
            int[] actual = stack.stream().mapToInt(k -> k).toArray();
            assertArrayEquals(String.format("case %d", i), expects[i], actual);
        }
    }
}