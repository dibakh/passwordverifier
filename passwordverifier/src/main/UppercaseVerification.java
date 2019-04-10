package main;

import static java.lang.Character.isUpperCase;

public class UppercaseVerification implements Verification {

    @Override
    public boolean verify(String password) {
        long numberOfUppercaseChars = password.chars()
                .filter(e -> isUpperCase(e))
                .count();

        return numberOfUppercaseChars > 0;
    }

}
