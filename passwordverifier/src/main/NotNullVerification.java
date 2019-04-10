package main;


import static java.util.Objects.isNull;

public class NotNullVerification implements Verification {
    public boolean verify(String password) {
        if (isNull(password) || password.isEmpty()) {
            return true;
        }
        return false;
    }
}