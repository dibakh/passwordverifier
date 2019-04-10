package test;

import main.LowercaseVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LowercaseVerificationTest {

    private LowercaseVerification verification = new LowercaseVerification();

    static Stream hasLowercase() {
        return Stream.of(
                Arguments.of(false, "A"),
                Arguments.of(true, "a"),
                Arguments.of(false, "1A"),
                Arguments.of(false, "(*&^%$#")
        );
    }

    @ParameterizedTest
    @MethodSource("hasLowercase")
    void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
        boolean actual = verification.verify(password);

        Assertions.assertEquals(expected, actual);
    }

}