package test;

import main.LowercaseCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class LowercaseConditionTest {

  private LowercaseCondition verification = new LowercaseCondition();

  static Stream hasLowercase() {
    return Stream.of(
        of(false, null),
        of(false, new String()),
        of(false, "A"),
        of(true, "a"),
        of(false, "1A"),
        of(false, "(*&^%$#")
    );
  }

  @ParameterizedTest
  @MethodSource("hasLowercase")
  void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
    boolean actual = verification.verify(password);

    Assertions.assertEquals(expected, actual);
  }

}