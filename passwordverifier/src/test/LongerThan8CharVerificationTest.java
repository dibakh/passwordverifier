package test;

import main.LongerThan8CharVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongerThan8CharVerificationTest {

    private LongerThan8CharVerification verification = new LongerThan8CharVerification();

    static Stream isNotNull() {
        return Stream.of(
                Arguments.of(false, "1234567"),
                Arguments.of(true, "12345678"),
                Arguments.of(true, "123456789")
        );
    }

    @ParameterizedTest
    @MethodSource("isNotNull")
    void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
        boolean actual = verification.verify(password);

        Assertions.assertEquals(expected, actual);
    }


}