package test;

import main.NumberVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberVerificationTest {

    private NumberVerification verification = new NumberVerification();

    static Stream hasNumber() {
        return Stream.of(
                Arguments.of(false, "A"),
                Arguments.of(false, "a"),
                Arguments.of(true, "4567890"),
                Arguments.of(true, "1a"),
                Arguments.of(false, "(*&^%$#")
        );
    }


    @ParameterizedTest
    @MethodSource("hasNumber")
    void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
        boolean actual = verification.verify(password);

        Assertions.assertEquals(expected, actual);
    }

}