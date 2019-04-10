package main;

public class LongerThan8CharVerification implements Verification {

    @Override
    public boolean verify(String password) {
        return password.length() >= 8;
    }
}
