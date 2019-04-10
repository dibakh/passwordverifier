package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions {
    private static List<Verification> verifier =
            Arrays.asList(
                    new LongerThan8CharVerification(),
                    new UppercaseVerification(),
                    new LowercaseVerification(),
                    new NumberVerification()
            );
    private static NotNullVerification nullOrEmptyVerifier = new NotNullVerification();

    public static List<Verification> asList() {
        return new ArrayList<>(verifier);
    }

    public static NotNullVerification getNullCondition() {
        return nullOrEmptyVerifier;
    }


}
