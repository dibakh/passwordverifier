package test;

import main.PasswordVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PasswordVerifierTest {

    private PasswordVerifier verification = new PasswordVerifier();

    static Stream hasAllConditions() {
        return Stream.of(
                Arguments.of(false, "Aa34567"), //less than 8 chars
                Arguments.of(false, null),
                Arguments.of(false, new String()),
                Arguments.of(false, "A12345678"),   //no lowercase
                Arguments.of(false, "a12345678"),   // no uppercase
                Arguments.of(false, "ABCDabcd"),    // no number
                Arguments.of(true, "Aa1Bb2Cc3"),    // all conditions
                Arguments.of(true, "Aa1@#$%^")      // all conditions
        );
    }

    static Stream verify3True() {
        return Stream.of(
                Arguments.of(true, "Aa34567"), //less than 8 chars
                Arguments.of(false, null),
                Arguments.of(false, new String()),
                Arguments.of(true, "A12345678"),   //no lowercase
                Arguments.of(true, "a12345678"),   // no uppercase
                Arguments.of(true, "ABCDabcd"),    // no number
                Arguments.of(true, "Aa1Bb2Cc3"),    // all conditions
                Arguments.of(true, "12345678"),
                Arguments.of(true, "AaBbCc"),
                Arguments.of(true, "Aa1@#$%^")      // all conditions
        );
    }

    static Stream verify3TrueAndLowercaseTrue() {
        return Stream.of(
                Arguments.of(true, "Aa34567"), //less than 8 chars
                Arguments.of(false, null),
                Arguments.of(false, new String()),
                Arguments.of(false, "A12345678"),   //no lowercase
                Arguments.of(true, "a12345678"),   // no uppercase
                Arguments.of(true, "ABCDabcd"),    // no number
                Arguments.of(true, "Aa1Bb2Cc3"),    // all conditions
                Arguments.of(false, "12345678"),
                Arguments.of(true, "AaBbCc"),
                Arguments.of(true, "Aa1@#$%^")      // all conditions
        );
    }

    @ParameterizedTest
    @MethodSource("hasAllConditions")
    void verifyAllCondition(boolean expected, String password) {
        boolean actual = verification.verifyAllCOnditionsTrue(password);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("verify3True")
    void verify3TrueConditions(boolean expected, String password) {
        boolean actual = verification.verify3TrueConditions(password);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("verify3TrueAndLowercaseTrue")
    void verify3TrueConditionsAndLowercase(boolean expected, String password) {
        boolean actual = verification.verify3TrueConditionsAndOneLowercaseChar(password);

        Assertions.assertEquals(expected, actual);
    }
}