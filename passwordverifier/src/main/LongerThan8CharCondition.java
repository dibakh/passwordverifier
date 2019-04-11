package main;

public class LongerThan8CharCondition implements Verification {

  public static final int minimumPasswordLength = 8;

  private NotNullCondition notNullCondition = Conditions.getNullCondition();

  @Override
  public boolean verify(String password) {
    if (!notNullCondition.verify(password)) {
      return false;
    }
    return password.length() > minimumPasswordLength;
  }
}
