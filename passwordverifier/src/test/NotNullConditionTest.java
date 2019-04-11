package test;

import main.NotNullCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NotNullConditionTest {

    private NotNullCondition verification = new NotNullCondition();

    static Stream isNotNull() {
        return Stream.of(
                Arguments.of(false, null),
                Arguments.of(false, new String()),
                Arguments.of(false, "")
        );
    }


    @ParameterizedTest
    @MethodSource("isNotNull")
    void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
        boolean actual = verification.verify(password);

        Assertions.assertEquals(expected, actual);
    }

}