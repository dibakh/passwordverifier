package main;


public class NotNullCondition implements Verification {
  public boolean verify(String password) {
    return password != null;
  }
}


