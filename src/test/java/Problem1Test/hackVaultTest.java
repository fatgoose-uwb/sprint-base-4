package Problem1Test;

/*
 * DO NOT MAKE ANY CHANGES
 */

import Problem1.PasswordHacker;
import Problem1.Vault;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class hackVaultTest {

    class TestCase {
        String range;
        String password;
        Integer secretValue;

        public TestCase(String range, String password, Integer secretValue) {
            this.range = range;
            this.password = password;
            this.secretValue = secretValue;
        }
    }

    @Test
    public void hackVault() {
        List<TestCase> testCases = Arrays.asList(
                new TestCase("1", "1", 9),
                new TestCase("123", "321", 5),
                new TestCase("1de", "de1", 4),
                new TestCase("6a7b8c", "cba678", 2),
                new TestCase("-,+xyz567", "x-5,6+y7z", 99)
        );

        for (TestCase testCase : testCases) {
            Vault vault = new Vault(testCase.password, testCase.secretValue);
            Integer actual = PasswordHacker.hack(vault, testCase.range);
            assertEquals(testCase.secretValue, actual);
        }
    }
}