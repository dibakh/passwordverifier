package main;

public class LongerThan8CharCondition implements Verification {

  public static final int MINIMUM_PASSWORD_LENGTH = 8;

  @Override
  public boolean verify(String password) {
    return password != null && password.length() > MINIMUM_PASSWORD_LENGTH;
  }
}
