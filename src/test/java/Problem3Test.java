import Problem3.Problem3;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Problem3Test {

    @Test
    public void testReversePrint() {
        int[][] inputs = {
                {},
                {1},
                {1, 2},
                {3, 3},
                {1, 4, 2},
                {3, 4, 5, 6, 7},
        };
        int[][] expected = {
                {},
                {1},
                {2, 1},
                {3, 3},
                {2, 4, 1},
                {7, 6, 5, 4, 3},
        };

        assertEquals(expected.length, inputs.length);

        for (int i = 0; i < inputs.length; i++) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);

            Problem3.printListInReverse(TestUtils.arrayToListWithoutDummy(inputs[i]), ps);

            String tmp = baos.toString().replace("\n", " ").replace("\r", "").trim();
            if (inputs[i].length != 0) {
                int[] actual = Arrays.stream(tmp.split(" ")).mapToInt(Integer::parseInt).toArray();
                assertArrayEquals(expected[i], actual);
            } else {
                assertEquals(0, tmp.length());
            }
        }
    }

    // and you thought we never use main() in this class ;)
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 4, 2},
                {3, 4, 5, 6, 7},
        };
        PrintStream toScreen = System.out;
        for (int[] input : inputs) {
            Problem3.printListInReverse(TestUtils.arrayToListWithoutDummy(input), toScreen);
            System.out.println();
        }
    }
}