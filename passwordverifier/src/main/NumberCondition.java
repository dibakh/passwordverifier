package main;

import java.util.stream.Stream;

public class NumberCondition implements Verification {
  private NotNullCondition notNullCondition = Conditions.getNullCondition();


  @Override
  public boolean verify(String password) {
    if (!notNullCondition.verify(password)) {
      return false;
    }

    return Stream.of(password)
                 .anyMatch(e -> e.matches(".*\\d.*"));

  }
}
