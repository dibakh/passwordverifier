package main;

import static java.lang.Character.isLowerCase;

public class LowercaseCondition implements Verification {

  @Override
  public boolean verify(String password) {
    return password != null && containsOneLowercaseLetter(password);
  }

  private boolean containsOneLowercaseLetter(String password) {
    return password.chars()
                   .anyMatch(e -> isLowerCase(e));
  }
}