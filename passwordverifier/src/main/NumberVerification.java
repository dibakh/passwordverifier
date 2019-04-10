package main;

import java.util.stream.Stream;

public class NumberVerification implements Verification {
    @Override
    public boolean verify(String password) {
        long numberOfNumbers = Stream.of(password.split(""))
                .filter(e -> e.matches(".*\\d.*"))
                .count();
        return numberOfNumbers > 0;

    }
}
