package test;

import main.NotNullVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NotNullVerificationTest {

    private NotNullVerification verification = new NotNullVerification();

    static Stream isNotNull() {
        return Stream.of(
                Arguments.of(true, null),
                Arguments.of(true, new String()),
                Arguments.of(true, "")
        );
    }


    @ParameterizedTest
    @MethodSource("isNotNull")
    void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
        boolean actual = verification.verify(password);

        Assertions.assertEquals(expected, actual);
    }

}