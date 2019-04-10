package main;

import static java.lang.Character.isLowerCase;

public class LowercaseVerification implements Verification {

    @Override
    public boolean verify(String password) {
        long numberOfLowercaseChars = password.chars()
                .filter(e -> isLowerCase(e))
                .count();

        return numberOfLowercaseChars > 0;
    }
}
