package test;

import main.NumberCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class NumberConditionTest {

  private NumberCondition verification = new NumberCondition();

  static Stream hasNumber() {
    return Stream.of(
        of(false, null),
        of(false, new String()),
        of(false, "A"),
        of(false, "a"),
        of(true, "4567890"),
        of(true, "1a"),
        of(false, "(*&^%$#")
    );
  }

  @ParameterizedTest
  @MethodSource("hasNumber")
  void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
    boolean actual = verification.verify(password);

    Assertions.assertEquals(expected, actual);
  }

}