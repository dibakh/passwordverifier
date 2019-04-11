package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions {
    private static List<Verification> verifier =
            Arrays.asList(
                    new LongerThan8CharCondition(),
                    new UppercaseCondition(),
                    new LowercaseCondition(),
                    new NumberCondition()
            );
    private static NotNullCondition nullOrEmptyVerifier = new NotNullCondition();

    public static List<Verification> asList() {
        return new ArrayList<>(verifier);
    }

    public static NotNullCondition getNullCondition() {
        return nullOrEmptyVerifier;
    }


}
