package main;

import java.util.List;

public class PasswordVerifier {

  public static final int MINIMUM_VALID_CONDITIONS = 3;

  private List<Verification> verifications = Conditions.asList();

  public boolean verify(String password) {
    return verifications.stream()
                        .filter(e -> e.verify(password))
                        .count() >= MINIMUM_VALID_CONDITIONS;
  }

}
