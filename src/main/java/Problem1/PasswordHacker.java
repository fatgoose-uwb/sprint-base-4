package Problem1;

import java.util.List;

public class PasswordHacker {
    /*
    DO NOT CHANGE ANYTHING IN THIS FUNCTION
     */
    public static Integer hack(Vault vault, String searchRange) {
        // remove duplicates from the search range
        String range = strDeDup(searchRange);

        // get all possible combinations with characters in the searchRange
        List<String> possiblePasswords = allPermutation(range);

        // try all the possible passwords
        for (String possiblePassword : possiblePasswords) {
            Integer secret = vault.challenge(possiblePassword);
            if (secret != null) {
                return secret;
            }
        }
        return null;
    }

    // DO NOT CHANGE ANYTHING ABOVE THIS LINE

    // OK to add a private helper function for recursion calls
    private static List<String> allPermutation(String searchRange) {
        // TODO: add your code
        return null;    // TODO: replace this placeholder with your code
    }

    /*
    READ the unit tests to understand how this function works
     */
    private static String strDeDup(String str) {   // read as "string de-deduplication"
        // TODO: add your code
        return null;    // TODO: replace this placeholder with your code
    }
}
