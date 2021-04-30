/*
 * DO NOT MAKE ANY CHANGES
 */

package Problem1;

import java.util.Objects;

public class Vault {
    private final String password;  // what's the "final" keyword for here?
    private final Integer secretValue;

    public Vault(String password, Integer secretValue) {
        this.password = password;
        this.secretValue = secretValue;
    }

    public Integer challenge(String password) {
        if (Objects.equals(password, this.password)) {
            return secretValue;
        }
        return null;
    }
}
