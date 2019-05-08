package main;

import static java.lang.Character.isUpperCase;

public class UppercaseCondition implements Verification {

  private NotNullCondition notNullCondition = Conditions.getNullCondition();

  @Override
  public boolean verify(String password) {
    return password != null && containsOneLowercaseLetter(password);
  }

  private boolean containsOneLowercaseLetter(String password) {
    return password.chars()
                   .anyMatch(e -> isUpperCase(e));
  }
}


