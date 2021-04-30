package Problem1Test;

import Problem1.PasswordHacker;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class strDeDupTest {
    private Method strDeDupFunc;

    @Before
    public void setUp() throws NoSuchMethodException {
        strDeDupFunc = PasswordHacker.class.getDeclaredMethod("strDeDup", String.class);
        strDeDupFunc.setAccessible(true);
    }

    private String strDeDup(String range)
            throws InvocationTargetException, IllegalAccessException {
        return (String) strDeDupFunc.invoke(null, range);
    }

    /*
    TODO: what does this test tell us?
     */
    @Test
    public void testRemoveDuplicates_EmptyString() throws InvocationTargetException, IllegalAccessException {
        String result = strDeDup("");
        assertStringEqualWithSort("", result);
    }

    /*
    TODO: what does this test tell us?
     */
    @Test
    public void testRemoveDuplicates_NoDuplicates() throws InvocationTargetException, IllegalAccessException {
        String result = strDeDup("abcdef");
        assertStringEqualWithSort("abcdef", result);
    }

    /*
    TODO: what does this test tell us?
     */
    @Test
    public void testRemoveDuplicates_WithDuplicates() throws InvocationTargetException, IllegalAccessException {
        String result = strDeDup("aabbcc");
        assertStringEqualWithSort("abc", result);
    }

    /*
    TODO: what does this test tell us?
     */
    @Test
    public void testRemoveDuplicates_MixedCase() throws InvocationTargetException, IllegalAccessException {
        String result = strDeDup("aAaBbBcC");
        assertStringEqualWithSort("abcABC", result);
    }

    /*
    TODO: what does this test tell us?
     */
    @Test
    public void testRemoveDuplicates_WithSpaces() throws InvocationTargetException, IllegalAccessException {
        String result = strDeDup("a b c b a");
        assertStringEqualWithSort(" abc", result);
    }

    /*
    TODO: what does this test tell us?
     */
    @Test
    public void testRemoveDuplicates_WithMixedCharacters() throws InvocationTargetException, IllegalAccessException {
        String result = strDeDup("1a2b3c1a2b");
        assertStringEqualWithSort("1a2b3c", result);
    }

    // DO NOT CHANGE ANY CODE ABOVE THIS LINE

    /*
    The test code above was written by ChatGPT using the following prompt:

    "Using Junit, write a set of unit tests for a function foo that removes duplicated character in a given string"

    Does it test the function? Yes, to an extent.

    Is it "clean"? Not so much. To start with, the "DRY" rule, Don't-Repeat-Yourself, and there are lots of repetitions here.

    Let's clean up these tests by adding one more test function that does the same tests but without repetition.
     */

    @Test
    public void myAwesomeCleanTest() {
        // TODO: add your test function that have the same test cases above but without unnecessary repetitions
        assertTrue(false);  // TODO: replace this placeholder with your code
    }

    // DO NOT CHANGE ANY CODE BELOW THIS LINE

    private void assertStringEqualWithSort(String str1, String str2) {
        str1 = sortString(str1);
        str2 = sortString(str2);
        assertEquals(str1, str2);
    }

    public static String sortString(String input) {
        if (input == null) {
            return null;
        }

        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        return new String(charArray);
    }

    @Test
    public void assertStringEqualWithSortTestEqualCases() {
        String[] str1 = {"abc", "1abcde", "", "ab", "a"};
        String[] str2 = {"bac", "aebdc1", "", "ba", "a"};

        assertEquals(str1.length, str2.length);
        for (int i = 0; i < str1.length; i++) {
            assertStringEqualWithSort(str1[i], str2[i]);
        }
    }

    @Test(expected = ComparisonFailure.class)
    public void assertStringEqualWithSortTestNotEqualCases() {
        assertStringEqualWithSort("abc123", "ab23");
    }
}
