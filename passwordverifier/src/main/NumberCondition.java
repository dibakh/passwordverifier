package main;

import java.util.stream.Stream;

public class NumberCondition implements Verification {

  public static final String NUMBER = ".*\\d.*";

  @Override
  public boolean verify(String password) {
    return password != null && containsOneNumber(password);
  }

  private boolean containsOneNumber(String password) {
    return Stream.of(password)
                 .anyMatch(e -> e.matches(NUMBER));
  }
}
