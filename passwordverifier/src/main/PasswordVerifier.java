package main;

import java.util.List;

public class PasswordVerifier {

    private List<Verification> verifications = Conditions.asList();
    private NotNullVerification nullCondition = Conditions.getNullCondition();

    public boolean verifyAllCOnditionsTrue(String password) {

        if (nullCondition.verify(password)) {
            return false;
        }

        return getNumberOfValidConditions(password) == verifications.size();

    }

    public boolean verify3TrueConditions(String password) {

        if (nullCondition.verify(password)) {
            return false;
        }

        return getNumberOfValidConditions(password) > 1;

    }

    public boolean verify3TrueConditionsAndOneLowercaseChar(String password) {

        if (nullCondition.verify(password)) {
            return false;
        }

        return result(password);

    }

    public long getNumberOfValidConditions(String password) {
        return verifications.stream()
                .filter(e -> e.verify(password))
                .count();
    }

    public boolean hasAtLeastOneLowercaseLetter(String password) {
        Verification numberVerification = verifications.get(2);
        return numberVerification.verify(password);
    }

    public boolean result(String password) {
        return getNumberOfValidConditions(password) > 1 && hasAtLeastOneLowercaseLetter(password);
    }

}
