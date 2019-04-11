package test;

import main.UppercaseCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class UppercaseConditionTest {

  private UppercaseCondition verification = new UppercaseCondition();

  static Stream hasUppercase() {
    return Stream.of(
        of(false, null),
        of(false, new String()),
        of(true, "A"),
        of(false, "a"),
        of(false, "1a"),
        of(false, "(*&^%$#")
    );
  }


  @ParameterizedTest
  @MethodSource("hasUppercase")
  void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
    boolean actual = verification.verify(password);

    Assertions.assertEquals(expected, actual);
  }
}