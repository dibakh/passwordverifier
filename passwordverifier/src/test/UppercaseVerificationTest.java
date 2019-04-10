package test;

import main.UppercaseVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UppercaseVerificationTest {

    private UppercaseVerification verification = new UppercaseVerification();

    static Stream hasUppercase() {
        return Stream.of(
                Arguments.of(true, "A"),
                Arguments.of(false, "a"),
                Arguments.of(false, "1a"),
                Arguments.of(false, "(*&^%$#")
        );
    }


    @ParameterizedTest
    @MethodSource("hasUppercase")
    void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
        boolean actual = verification.verify(password);

        Assertions.assertEquals(expected, actual);
    }
}