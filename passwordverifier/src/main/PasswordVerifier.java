package main;

import java.util.List;

public class PasswordVerifier {

  public static final int minimumValidConditions = 1;

  private List<Verification> verifications = Conditions.asList();
  private NotNullCondition notNullCondition = Conditions.getNullCondition();

  public boolean verifyAllCOnditionsTrue(String password) {

    if (!notNullCondition.verify(password)) {
      return false;
    }

    return getNumberOfValidConditions(password) == verifications.size();

  }

  public boolean verify3TrueConditions(String password) {

    if (!notNullCondition.verify(password)) {
      return false;
    }

    return getNumberOfValidConditions(password) > minimumValidConditions;

  }

  public boolean verify3TrueConditionsAndOneLowercaseChar(String password) {

    if (!notNullCondition.verify(password)) {
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
    Verification numberVerification = new NumberCondition();
    return numberVerification.verify(password);
  }

  public boolean result(String password) {
    return getNumberOfValidConditions(password) > minimumValidConditions
        && hasAtLeastOneLowercaseLetter(password);
  }

}
