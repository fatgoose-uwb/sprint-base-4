/*
 * DO NOT MAKE ANY CHANGES
 */

package Problem1Test;

import Problem1.PasswordHacker;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class allPermutationTest {

    private Method allPermutationFunc;

    public static class PermutationTestCase {
        String characterRange;
        List<String> expect;

        public PermutationTestCase(String characterRange, List<String> expect) {
            this.characterRange = characterRange;
            this.expect = expect;
            Collections.sort(expect);
        }
    }

    @Before
    public void setUp() throws NoSuchMethodException {
        allPermutationFunc = PasswordHacker.class.getDeclaredMethod("allPermutation", String.class);
        allPermutationFunc.setAccessible(true);
    }

    private List<String> allPermutation(String range)
            throws InvocationTargetException, IllegalAccessException {
        return (List<String>) allPermutationFunc.invoke(null, range);
    }

    @Test
    public void allPermutation() throws InvocationTargetException, IllegalAccessException {

        List<PermutationTestCase> testCases = getAllPermutationTestCases();

        for (int i = 0; i < testCases.size(); i++) {
            PermutationTestCase testCase = testCases.get(i);

            List<String> results = allPermutation(testCase.characterRange);
            Collections.sort(results);

            assertEquals("case " + i, testCase.expect, results);
        }
    }

    @Test
    public void testLargeInputs() {
    /*
     TODO: Extra credit.
      Write tests for large input string such as 10, 20, and 30 characters.
      Tip: For this, please do not hard-code all the possible combinations due to the large amount of possible
      combinations when the string is large.
     */
    }

    private List<PermutationTestCase> getAllPermutationTestCases() {
        List<PermutationTestCase> testCases = new ArrayList<>();
        testCases.add(new PermutationTestCase("", Arrays.asList("")));
        testCases.add(new PermutationTestCase("2", Arrays.asList("2")));
        testCases.add(new PermutationTestCase("a2", Arrays.asList("a2", "2a")));
        testCases.add(new PermutationTestCase("a2c", Arrays.asList("a2c", "ac2", "2ac", "2ca", "ca2", "c2a")));
        testCases.add(new PermutationTestCase(
                "a2c4",
                Arrays.asList(
                        "a2c4", "a24c", "ac24", "ac42", "a42c", "a4c2",
                        "2ac4", "2a4c", "2ca4", "2c4a", "24ac", "24ca",
                        "c2a4", "c24a", "ca24", "ca42", "c42a", "c4a2",
                        "42ca", "42ac", "4c2a", "4ca2", "4a2c", "4ac2")));
        return testCases;
    }
}