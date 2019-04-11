package main;


import static java.util.Objects.isNull;

public class NotNullCondition implements Verification {
    public boolean verify(String password) {
        if (isNull(password) || password.isEmpty()) {
            return false;
        }
        return true;
    }
}


