package main;

import static java.lang.Character.isLowerCase;

public class LowercaseCondition implements Verification {

    private NotNullCondition notNullCondition = Conditions.getNullCondition();

    @Override
    public boolean verify(String password) {

        if (!notNullCondition.verify(password)) {
            return false;
        }
        return password.chars()
                .anyMatch(e -> isLowerCase(e));
    }
}


