package main;

import static java.lang.Character.isUpperCase;

public class UppercaseCondition implements Verification {

  private NotNullCondition notNullCondition = Conditions.getNullCondition();

  @Override
  public boolean verify(String password) {

    if (!notNullCondition.verify(password)) {
      return false;
    }

    return password.chars()
                   .anyMatch(e -> isUpperCase(e));

  }

}


